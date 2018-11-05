/**
 * @author Jay <jwang@dizsoft.com>
 */

(function ($) {
    'use strict';
    var sprintf = $.fn.bootstrapTable.utils.sprintf;

    $.extend($.fn.bootstrapTable.defaults, {
        showJumpto: false,
        exportOptions: {}
    });

    $.extend($.fn.bootstrapTable.locales, {
        formatJumpto: function () {
            return '确定';
        }
    });
    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales);

    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initPagination = BootstrapTable.prototype.initPagination;

    BootstrapTable.prototype.initPagination = function () {
        _initPagination.apply(this, Array.prototype.slice.apply(arguments));

        if (this.options.showJumpto) {
            var that = this,
                $pageGroup = this.$pagination.find('ul.pagination'),
                $jumpto = $pageGroup.find('li.jumpto');

            if (!$jumpto.length) {
                $jumpto = $([
                    '<li class="jumpto">',
                    '<span>跳转到</span>',
                    '<input type="text" class="form-control" >',
                    '<span>页</span>',
                    '<button class="btn' +
                    sprintf(' btn-%s', this.options.buttonsClass) +
                    sprintf(' btn-%s', this.options.iconSize) +
                    '" title="' + this.options.formatJumpto() + '" ' +
                    ' type="button">' + this.options.formatJumpto(),
                    '</button>',
                    '</li>'].join('')).appendTo($pageGroup);

                $jumpto.find('button').click(function () {
                    that.selectPage(parseInt($jumpto.find('input').val()));
                });
                //限制键盘只能按数字键、小键盘数字键、退格键
                $(".form-control").keydown(function (e) {
                    var code = parseInt(e.keyCode);
                    if (code >= 96 && code <= 105 || code >= 48 && code <= 57 || code == 8) {
                        return true;
                    } else {
                        return false;
                    }
                })

                //文本框输入事件,任何非正整数的输入都重置为1
                $(".form-control").bind("input propertychange", function () {
                    var num = $(this).val();
                    var regu = /^[1-9]\d*$/;
                    if(num&&(!regu.test(num))) {
                        $(this).val(1);
                    }
                })

            }
        }
    };
})(jQuery);
