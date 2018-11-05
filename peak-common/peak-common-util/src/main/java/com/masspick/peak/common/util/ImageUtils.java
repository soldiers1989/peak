package com.masspick.peak.common.util;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.ImagingOpException;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图像工具类
 */
public final class ImageUtils {


    /**
     * 工具类隐藏public的构造器
     */
    private ImageUtils() {

    }


    /**
     * 系统参数 imgscalr.debug
     */
    public static final String DEBUG_PROPERTY_NAME = "imgscalr.debug";


    /**
     * 系统参数 imgscalr.logPrefix
     */
    public static final String LOG_PREFIX_PROPERTY_NAME = "imgscalr.logPrefix";

    /**
     * 日志开关
     */
    public static final boolean DEBUG = Boolean.getBoolean(DEBUG_PROPERTY_NAME);

    /**
     * RPG 色值的最大值
     */
    private static final int COLOR_MAX_VAL = 255;

    /**
     * 日志前缀
     */
    public static final String LOG_PREFIX = System.getProperty(
            LOG_PREFIX_PROPERTY_NAME, "[imgscalr] ");


    /**
     * 默认的图片锯齿选项
     */
    public static final ConvolveOp OP_ANTIALIAS = new ConvolveOp(
            new Kernel(3, 3, new float[]{.0f, .08f, .0f, .08f, .68f, .08f,
                    .0f, .08f, .0f}), ConvolveOp.EDGE_NO_OP, null);


    /**
     * 使图片黑10%
     */
    public static final RescaleOp OP_DARKER = new RescaleOp(0.9f, 0, null);


    /**
     * 使图片亮10%
     */
    public static final RescaleOp OP_BRIGHTER = new RescaleOp(1.1f, 0, null);


    /**
     * 使图片转出灰色
     */
    public static final ColorConvertOp OP_GRAYSCALE = new ColorConvertOp(
            ColorSpace.getInstance(ColorSpace.CS_GRAY), null);


    static {
        log(0, "Debug output ENABLED");
    }


    /**
     * 缩放枚举
     */
    public enum Method {

        /**
         * 自动
         */
        AUTOMATIC,


        /**
         * 快速
         */
        SPEED,


        /**
         * 平衡
         */
        BALANCED,


        /**
         * 高质量
         */
        QUALITY,


        /**
         * 超高质量
         */
        ULTRA_QUALITY;
    }


    /**
     * 压缩模式
     */
    public enum Mode {

        /**
         * 自动
         */
        AUTOMATIC,

        /**
         * 固定尺寸
         */
        FIT_EXACT,


        /**
         * 计算模式
         * 适用于边框内最大图像
         */
        BEST_FIT_BOTH,

        /**
         * 适配宽度
         */
        FIT_TO_WIDTH,

        /**
         * 适配高度
         */
        FIT_TO_HEIGHT;
    }


    /**
     * 选择模式
     */
    public enum Rotation {

        /**
         * 向右旋转 90
         */
        CW_90,

        /**
         * 向右旋转 180
         */
        CW_180,

        /**
         * 向右旋转 270
         */
        CW_270,

        /**
         * 水平翻转
         */
        FLIP_HORZ,

        /**
         * 垂直翻转
         */
        FLIP_VERT;
    }


    /**
     * THRESHOLD_BALANCED_SPEED
     */
    public static final int THRESHOLD_BALANCED_SPEED = 1600;


    /**
     * THRESHOLD_QUALITY_BALANCED
     */
    public static final int THRESHOLD_QUALITY_BALANCED = 800;


    /**
     * 应用图像处理
     *
     * @param src 应用ops的图像
     * @param ops 应用于图像的操作
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage apply(BufferedImage src, BufferedImageOp... ops)
            throws IllegalArgumentException, ImagingOpException {
        long t = -1;
        if (DEBUG) {
            t = System.currentTimeMillis();
        }

        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (ops == null || ops.length == 0) {
            throw new IllegalArgumentException("ops cannot be null or empty");
        }

        int type = src.getType();

        if (!(type == BufferedImage.TYPE_INT_RGB || type == BufferedImage.TYPE_INT_ARGB)) {
            src = copyToOptimalImage(src);
        }

        if (DEBUG) {
            log(0, "Applying %d BufferedImageOps...", ops.length);
        }

        boolean hasReassignedSrc = false;

        for (int i = 0; i < ops.length; i++) {
            long subT = -1;
            if (DEBUG) {
                subT = System.currentTimeMillis();
            }
            BufferedImageOp op = ops[i];

            // Skip null ops instead of throwing an exception.
            if (op == null) {
                continue;
            }

            if (DEBUG) {
                log(1, "Applying BufferedImageOp [class=%s, toString=%s]...",
                        op.getClass(), op.toString());
            }

            Rectangle2D resultBounds = op.getBounds2D(src);

            // Watch out for flaky/misbehaving ops that fail to work right.
            if (resultBounds == null) {
                throw new ImagingOpException(
                        "BufferedImageOp ["
                                + op.toString()
                                + "] getBounds2D(src) returned null bounds for the target image; this should not happen "
                                + "and indicates a problem with application of this type of op.");
            }

            BufferedImage dest = createOptimalImage(src,
                    (int) Math.round(resultBounds.getWidth()),
                    (int) Math.round(resultBounds.getHeight()));

            // Perform the operation, update our result to return.
            BufferedImage result = op.filter(src, dest);
            if (hasReassignedSrc) {
                src.flush();
            }

            src = result;

            hasReassignedSrc = true;

            if (DEBUG) {
                log(1,
                        "Applied BufferedImageOp in %d ms, result [width=%d, height=%d]",
                        System.currentTimeMillis() - subT, result.getWidth(),
                        result.getHeight());
            }
        }

        if (DEBUG) {
            log(0, "All %d BufferedImageOps applied in %d ms", ops.length,
                    System.currentTimeMillis() - t);
        }

        return src;
    }


    /**
     * 裁剪
     *
     * @param src
     * @param width
     * @param height
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage crop(BufferedImage src, int width, int height,
                                     BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return crop(src, 0, 0, width, height, ops);
    }


    /**
     * 裁剪
     *
     * @param src
     * @param x
     * @param y
     * @param width
     * @param height
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage crop(BufferedImage src, int x, int y,
                                     int width, int height, BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        long t = -1;
        if (DEBUG) {
            t = System.currentTimeMillis();
        }

        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (x < 0 || y < 0 || width < 0 || height < 0) {
            throw new IllegalArgumentException("Invalid crop bounds: x [" + x
                    + "], y [" + y + "], width [" + width + "] and height ["
                    + height + "] must all be >= 0");
        }

        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();

        if ((x + width) > srcWidth) {
            throw new IllegalArgumentException(
                    "Invalid crop bounds: x + width [" + (x + width)
                            + "] must be <= src.getWidth() [" + srcWidth + "]");
        }
        if ((y + height) > srcHeight) {
            throw new IllegalArgumentException(
                    "Invalid crop bounds: y + height [" + (y + height)
                            + "] must be <= src.getHeight() [" + srcHeight
                            + "]");
        }

        if (DEBUG) {
            log(0,
                    "Cropping Image [width=%d, height=%d] to [x=%d, y=%d, width=%d, height=%d]...",
                    srcWidth, srcHeight, x, y, width, height);
        }

        // Create a target image of an optimal type to render into.
        BufferedImage result = createOptimalImage(src, width, height);
        Graphics g = result.getGraphics();

        // Render the region specified by our crop bounds from the src image
        // directly into our result image (which is the exact size of the crop
        // region).
        g.drawImage(src, 0, 0, width, height, x, y, (x + width), (y + height),
                null);
        g.dispose();

        if (DEBUG) {
            log(0, "Cropped Image in %d ms", System.currentTimeMillis() - t);
        }

        // Apply any optional operations (if specified).
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }

        return result;
    }


    /**
     * 填充
     *
     * @param src
     * @param padding
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage pad(BufferedImage src, int padding,
                                    BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return pad(src, padding, Color.BLACK);
    }


    /**
     * 填充
     *
     * @param src
     * @param padding
     * @param color
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage pad(BufferedImage src, int padding,
                                    Color color, BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        long t = -1;
        if (DEBUG) {
            t = System.currentTimeMillis();
        }

        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (padding < 1) {
            throw new IllegalArgumentException("padding [" + padding
                    + "] must be > 0");
        }
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null");
        }

        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();

        // Double the padding to account for all sides of the image. More
        // specifically, if padding is "1" we add 2 pixels to width and 2 to
        // height, so we have 1 new pixel of padding all the way around our
        // image.
        int sizeDiff = (padding * 2);
        int newWidth = srcWidth + sizeDiff;
        int newHeight = srcHeight + sizeDiff;

        if (DEBUG) {
            log(0,
                    "Padding Image from [originalWidth=%d, originalHeight=%d, padding=%d] to [newWidth=%d, newHeight=%d]...",
                    srcWidth, srcHeight, padding, newWidth, newHeight);
        }

        boolean colorHasAlpha = (color.getAlpha() != COLOR_MAX_VAL);
        boolean imageHasAlpha = (src.getTransparency() != BufferedImage.OPAQUE);

        BufferedImage result;

        // We need to make sure our resulting image that we render into contains
        // alpha if either our original image OR the padding color we are using
        // contain it.
        if (colorHasAlpha || imageHasAlpha) {
            if (DEBUG) {
                log(1,
                        "Transparency FOUND in source image or color, using ARGB image type...");
            }

            result = new BufferedImage(newWidth, newHeight,
                    BufferedImage.TYPE_INT_ARGB);
        } else {
            if (DEBUG) {
                log(1,
                        "Transparency NOT FOUND in source image or color, using RGB image type...");
            }

            result = new BufferedImage(newWidth, newHeight,
                    BufferedImage.TYPE_INT_RGB);
        }

        Graphics g = result.getGraphics();

        // Draw the border of the image in the color specified.
        g.setColor(color);
        g.fillRect(0, 0, newWidth, padding);
        g.fillRect(0, padding, padding, newHeight);
        g.fillRect(padding, newHeight - padding, newWidth, newHeight);
        g.fillRect(newWidth - padding, padding, newWidth, newHeight - padding);

        // Draw the image into the center of the new padded image.
        g.drawImage(src, padding, padding, null);
        g.dispose();

        if (DEBUG) {
            log(0, "Padding Applied in %d ms", System.currentTimeMillis() - t);
        }

        // Apply any optional operations (if specified).
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }

        return result;
    }


    /**
     * 压缩
     *
     * @param src
     * @param targetSize
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, int targetSize,
                                       BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetSize,
                targetSize, ops);
    }


    /**
     * 压缩
     *
     * @param src
     * @param scalingMethod
     * @param targetSize
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, Method scalingMethod,
                                       int targetSize, BufferedImageOp... ops)
            throws IllegalArgumentException, ImagingOpException {
        return resize(src, scalingMethod, Mode.AUTOMATIC, targetSize,
                targetSize, ops);
    }

    /**
     * 压缩
     *
     * @param src
     * @param resizeMode
     * @param targetSize
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, Mode resizeMode,
                                       int targetSize, BufferedImageOp... ops)
            throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, resizeMode, targetSize,
                targetSize, ops);
    }


    /**
     * 压缩
     *
     * @param src
     * @param scalingMethod
     * @param resizeMode
     * @param targetSize
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, Method scalingMethod,
                                       Mode resizeMode, int targetSize, BufferedImageOp... ops)
            throws IllegalArgumentException, ImagingOpException {
        return resize(src, scalingMethod, resizeMode, targetSize, targetSize,
                ops);
    }


    /**
     * 压缩
     *
     * @param src
     * @param targetWidth
     * @param targetHeight
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, int targetWidth,
                                       int targetHeight, BufferedImageOp... ops)
            throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, Mode.AUTOMATIC, targetWidth,
                targetHeight, ops);
    }


    /**
     * 压缩
     *
     * @param src
     * @param scalingMethod
     * @param targetWidth
     * @param targetHeight
     * @param ops
     * @return BufferedImage
     */
    public static BufferedImage resize(BufferedImage src, Method scalingMethod,
                                       int targetWidth, int targetHeight, BufferedImageOp... ops) {
        return resize(src, scalingMethod, Mode.AUTOMATIC, targetWidth,
                targetHeight, ops);
    }

    /**
     * 压缩
     *
     * @param src
     * @param resizeMode
     * @param targetWidth
     * @param targetHeight
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, Mode resizeMode,
                                       int targetWidth, int targetHeight, BufferedImageOp... ops)
            throws IllegalArgumentException, ImagingOpException {
        return resize(src, Method.AUTOMATIC, resizeMode, targetWidth,
                targetHeight, ops);
    }


    /**
     * 压缩
     *
     * @param src
     * @param scalingMethod
     * @param resizeMode
     * @param targetWidth
     * @param targetHeight
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage resize(BufferedImage src, Method scalingMethod,
                                       Mode resizeMode, int targetWidth, int targetHeight,
                                       BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        long t = -1;
        if (DEBUG) {
            t = System.currentTimeMillis();
        }
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (targetWidth < 0) {
            throw new IllegalArgumentException("targetWidth must be >= 0");
        }
        if (targetHeight < 0) {
            throw new IllegalArgumentException("targetHeight must be >= 0");
        }
        if (scalingMethod == null) {
            throw new IllegalArgumentException(
                    "scalingMethod cannot be null. A good default value is Method.AUTOMATIC.");
        }
        if (resizeMode == null) {
            throw new IllegalArgumentException(
                    "resizeMode cannot be null. A good default value is Mode.AUTOMATIC.");
        }
        BufferedImage result = null;
        int currentWidth = src.getWidth();
        int currentHeight = src.getHeight();
        float ratio = ((float) currentHeight / (float) currentWidth);
        if (DEBUG) {
            log(0,
                    "Resizing Image [size=%dx%d, resizeMode=%s, orientation=%s, ratio(H/W)=%f] to [targetSize=%dx%d]",
                    currentWidth, currentHeight, resizeMode,
                    (ratio <= 1 ? "Landscape/Square" : "Portrait"), ratio,
                    targetWidth, targetHeight);
        }
        if (resizeMode == Mode.FIT_EXACT) {
            if (DEBUG) {
                log(1,
                        "Resize Mode FIT_EXACT used, no width/height checking or re-calculation will be done.");
            }
        } else if (resizeMode == Mode.BEST_FIT_BOTH) {
            float requestedHeightScaling = ((float) targetHeight / (float) currentHeight);
            float requestedWidthScaling = ((float) targetWidth / (float) currentWidth);
            float actualScaling = Math.min(requestedHeightScaling, requestedWidthScaling);
            targetHeight = Math.round((float) currentHeight * actualScaling);
            targetWidth = Math.round((float) currentWidth * actualScaling);
            if (targetHeight == currentHeight && targetWidth == currentWidth) {
                return src;
            }
            if (DEBUG) {
                log(1, "Auto-Corrected width and height based on scalingRatio %d.", actualScaling);
            }
        } else {
            if ((ratio <= 1 && resizeMode == Mode.AUTOMATIC)
                    || (resizeMode == Mode.FIT_TO_WIDTH)) {
                if (targetWidth == src.getWidth()) {
                    return src;
                }
                int originalTargetHeight = targetHeight;
                targetHeight = (int) Math.ceil((float) targetWidth * ratio);
                if (DEBUG && originalTargetHeight != targetHeight) {
                    log(1,
                            "Auto-Corrected targetHeight [from=%d to=%d] to honor image proportions.",
                            originalTargetHeight, targetHeight);
                }
            } else {
                if (targetHeight == src.getHeight()) {
                    return src;
                }
                int originalTargetWidth = targetWidth;
                targetWidth = Math.round((float) targetHeight / ratio);
                if (DEBUG && originalTargetWidth != targetWidth) {
                    log(1,
                            "Auto-Corrected targetWidth [from=%d to=%d] to honor image proportions.",
                            originalTargetWidth, targetWidth);
                }
            }
        }
        if (scalingMethod == Method.AUTOMATIC) {
            scalingMethod = determineScalingMethod(targetWidth, targetHeight,
                    ratio);
        }
        if (DEBUG) {
            log(1, "Using Scaling Method: %s", scalingMethod);
        }
        if (scalingMethod == Method.SPEED) {
            result = scaleImage(src, targetWidth, targetHeight,
                    RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        } else if (scalingMethod == Method.BALANCED) {
            result = scaleImage(src, targetWidth, targetHeight,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        } else if (scalingMethod == Method.QUALITY
                || scalingMethod == Method.ULTRA_QUALITY) {
            if (targetWidth > currentWidth || targetHeight > currentHeight) {
                if (DEBUG) {
                    log(1,
                            "QUALITY scale-up, a single BICUBIC scale operation will be used...");
                }
                result = scaleImage(src, targetWidth, targetHeight,
                        RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            } else {
                if (DEBUG) {
                    log(1,
                            "QUALITY scale-down, incremental scaling will be used...");
                }
                result = scaleImageIncrementally(src, targetWidth,
                        targetHeight, scalingMethod,
                        RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            }
        }
        if (DEBUG) {
            log(0, "Resized Image in %d ms", System.currentTimeMillis() - t);
        }
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }
        return result;
    }


    /**
     * 旋转
     *
     * @param src
     * @param rotation
     * @param ops
     * @return BufferedImage
     * @throws IllegalArgumentException IllegalArgumentException
     * @throws ImagingOpException       ImagingOpException
     */
    public static BufferedImage rotate(BufferedImage src, Rotation rotation,
                                       BufferedImageOp... ops) throws IllegalArgumentException, ImagingOpException {
        long t = -1;
        if (DEBUG) {
            t = System.currentTimeMillis();
        }

        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }
        if (rotation == null) {
            throw new IllegalArgumentException("rotation cannot be null");
        }

        if (DEBUG) {
            log(0, "Rotating Image [%s]...", rotation);
        }

        int newWidth = src.getWidth();
        int newHeight = src.getHeight();

        AffineTransform tx = new AffineTransform();

        switch (rotation) {
            case CW_90:

                // A 90 or -90 degree rotation will cause the height and width to
                // flip-flop from the original image to the rotated one.
                newWidth = src.getHeight();
                newHeight = src.getWidth();

                // Reminder: newWidth == result.getHeight() at this point
                tx.translate(newWidth, 0);
                tx.quadrantRotate(1);
                break;

            case CW_270:

                // A 90 or -90 degree rotation will cause the height and width to
                // flip-flop from the original image to the rotated one.
                newWidth = src.getHeight();
                newHeight = src.getWidth();

                // Reminder: newHeight == result.getWidth() at this point
                tx.translate(0, newHeight);
                tx.quadrantRotate(3);
                break;

            case CW_180:
                tx.translate(newWidth, newHeight);
                tx.quadrantRotate(2);
                break;

            case FLIP_HORZ:
                tx.translate(newWidth, 0);
                tx.scale(-1.0, 1.0);
                break;

            case FLIP_VERT:
                tx.translate(0, newHeight);
                tx.scale(1.0, -1.0);
                break;
            default:
                if (DEBUG) {
                    log(0, "无效的旋转类型");
                }
                break;
        }

        // Create our target image we will render the rotated result to.
        BufferedImage result = createOptimalImage(src, newWidth, newHeight);
        Graphics2D g2d = (Graphics2D) result.createGraphics();


        // Render the resultant image to our new rotatedImage buffer, applying
        // the AffineTransform that we calculated above during rendering so the
        // pixels from the old position are transposed to the new positions in
        // the resulting image correctly.

        g2d.drawImage(src, tx, null);
        g2d.dispose();

        if (DEBUG) {
            log(0, "Rotation Applied in %d ms, result [width=%d, height=%d]",
                    System.currentTimeMillis() - t, result.getWidth(),
                    result.getHeight());
        }

        // Apply any optional operations (if specified).
        if (ops != null && ops.length > 0) {
            result = apply(result, ops);
        }

        return result;
    }


    /**
     * 日志方法
     *
     * @param depth
     * @param message
     * @param params
     */
    protected static void log(int depth, String message, Object... params) {
        if (ImageUtils.DEBUG) {
            System.out.print(ImageUtils.LOG_PREFIX);

            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }

            System.out.printf(message, params);
            System.out.println();
        }
    }


    /**
     * 创建最佳图像
     *
     * @param src
     * @return BufferedImage
     */
    protected static BufferedImage createOptimalImage(BufferedImage src) {
        return createOptimalImage(src, src.getWidth(), src.getHeight());
    }


    /**
     * 创建最佳图像
     *
     * @param src
     * @param width
     * @param height
     * @return BufferedImage
     * @throws IllegalArgumentException
     */
    protected static BufferedImage createOptimalImage(BufferedImage src,
                                                      int width, int height) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width [" + width
                    + "] and height [" + height + "] must be > 0");
        }

        return new BufferedImage(
                width,
                height,
                (src.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB
                        : BufferedImage.TYPE_INT_ARGB));
    }


    /**
     * 创建最佳图像
     *
     * @param src
     * @return BufferedImage
     * @throws IllegalArgumentException
     */
    protected static BufferedImage copyToOptimalImage(BufferedImage src)
            throws IllegalArgumentException {
        if (src == null) {
            throw new IllegalArgumentException("src cannot be null");
        }

        // Calculate the type depending on the presence of alpha.
        int type = (src.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB
                : BufferedImage.TYPE_INT_ARGB);
        BufferedImage result = new BufferedImage(src.getWidth(),
                src.getHeight(), type);

        // Render the src image into our new optimal source.
        Graphics g = result.getGraphics();
        g.drawImage(src, 0, 0, null);
        g.dispose();

        return result;
    }

    /**
     * Used to determine the scaling {@link Method} that is best suited for
     * scaling the image to the targeted dimensions.
     * <p/>
     * This method is intended to be used to select a specific scaling
     * {@link Method} when a {@link Method#AUTOMATIC} method is specified. This
     * method utilizes the {@link ImageUtils#THRESHOLD_QUALITY_BALANCED} and
     * {@link ImageUtils#THRESHOLD_BALANCED_SPEED} thresholds when selecting which
     * method should be used by comparing the primary dimension (width or
     * height) against the threshold and seeing where the image falls. The
     * primary dimension is determined by looking at the orientation of the
     * image: landscape or square images use their width and portrait-oriented
     * images use their height.
     *
     * @param targetWidth  The target width for the scaled image.
     * @param targetHeight The target height for the scaled image.
     * @param ratio        A height/width ratio used to determine the orientation of the
     *                     image so the primary dimension (width or height) can be
     *                     selected to test if it is greater than or less than a
     *                     particular threshold.
     * @return the fastest {@link Method} suited for scaling the image to the
     * specified dimensions while maintaining a good-looking result.
     */
    protected static Method determineScalingMethod(int targetWidth,
                                                   int targetHeight, float ratio) {
        // Get the primary dimension based on the orientation of the image
        int length = (ratio <= 1 ? targetWidth : targetHeight);

        // Default to speed
        Method result = Method.SPEED;

        // Figure out which scalingMethod should be used
        if (length <= ImageUtils.THRESHOLD_QUALITY_BALANCED) {
            result = Method.QUALITY;
        } else if (length <= ImageUtils.THRESHOLD_BALANCED_SPEED) {
            result = Method.BALANCED;
        }

        if (DEBUG) {
            log(2, "AUTOMATIC scaling method selected: %s", result.name());
        }

        return result;
    }


    /**
     * 裁剪
     *
     * @param src
     * @param targetWidth
     * @param targetHeight
     * @param interpolationHintValue
     * @return BufferedImage
     */
    protected static BufferedImage scaleImage(BufferedImage src,
                                              int targetWidth, int targetHeight, Object interpolationHintValue) {
        // Setup the rendering resources to match the source image's
        BufferedImage result = createOptimalImage(src, targetWidth,
                targetHeight);
        Graphics2D resultGraphics = result.createGraphics();

        // Scale the image to the new buffer using the specified rendering hint.
        resultGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                interpolationHintValue);
        resultGraphics.drawImage(src, 0, 0, targetWidth, targetHeight, null);

        // Just to be clean, explicitly dispose our temporary graphics object
        resultGraphics.dispose();

        // Return the scaled image to the caller.
        return result;
    }


    /**
     * 裁剪
     *
     * @param src
     * @param targetWidth
     * @param targetHeight
     * @param scalingMethod
     * @param interpolationHintValue
     * @return BufferedImage
     */
    protected static BufferedImage scaleImageIncrementally(BufferedImage src,
                                                           int targetWidth, int targetHeight, Method scalingMethod,
                                                           Object interpolationHintValue) {
        boolean hasReassignedSrc = false;
        int incrementCount = 0;
        int currentWidth = src.getWidth();
        int currentHeight = src.getHeight();

        int fraction = (scalingMethod == Method.ULTRA_QUALITY ? 7 : 2);

        do {
            int prevCurrentWidth = currentWidth;
            int prevCurrentHeight = currentHeight;

            // If the current width is bigger than our target, cut it in half
            // and sample again.
            if (currentWidth > targetWidth) {
                currentWidth -= (currentWidth / fraction);

                // If we cut the width too far it means we are on our last
                // iteration. Just set it to the target width and finish up.
                if (currentWidth < targetWidth) {
                    currentWidth = targetWidth;
                }
            }

            // If the current height is bigger than our target, cut it in half
            // and sample again.
            if (currentHeight > targetHeight) {
                currentHeight -= (currentHeight / fraction);

                // If we cut the height too far it means we are on our last
                // iteration. Just set it to the target height and finish up.
                if (currentHeight < targetHeight) {
                    currentHeight = targetHeight;
                }
            }

            if (prevCurrentWidth == currentWidth
                    && prevCurrentHeight == currentHeight) {
                break;
            }

            if (DEBUG) {
                log(2, "Scaling from [%d x %d] to [%d x %d]", prevCurrentWidth,
                        prevCurrentHeight, currentWidth, currentHeight);
            }

            // Render the incremental scaled image.
            BufferedImage incrementalImage = scaleImage(src, currentWidth,
                    currentHeight, interpolationHintValue);

            if (hasReassignedSrc) {
                src.flush();
            }

            // Now treat our incremental partially scaled image as the src image
            // and cycle through our loop again to do another incremental
            // scaling of it (if necessary).
            src = incrementalImage;

            // Keep track of us re-assigning the original caller-supplied source
            // image with one of our interim BufferedImages so we know when to
            // explicitly flush the interim "src" on the next cycle through.
            hasReassignedSrc = true;

            // Track how many times we go through this cycle to scale the image.
            incrementCount++;
        } while (currentWidth != targetWidth || currentHeight != targetHeight);

        if (DEBUG) {
            log(2, "Incrementally Scaled Image in %d steps.", incrementCount);
        }

        // Once the loop has exited, the src image argument is now our scaled
        // result image that we want to return.
        return src;
    }

    /**
     * InputStream 转 BufferImage
     *
     * @param stream
     * @return BufferedImage
     * @throws IOException IOException
     */
    public static BufferedImage convert(InputStream stream) throws IOException {
        BufferedImage image = ImageIO.read(stream);
        return image;
    }

    /**
     * BufferImage 转 InputStream
     *
     * @param image
     * @param formatName
     * @return InputStream
     * @throws IOException IOException
     */
    public static InputStream convert(BufferedImage image, String formatName) throws IOException {
        if (image == null) {
            throw new IllegalArgumentException("image cannot be null");
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, formatName, os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

    /**
     * BufferImage 转 InputStream
     *
     * @param image
     * @return InputStream
     * @throws IOException IOException
     */
    public static InputStream convert(BufferedImage image) throws IOException {

        //默认图片格式为jpg
        return convert(image, "PNG");
    }
}
