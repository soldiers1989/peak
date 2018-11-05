package com.masspick.peak.dd.controller;

import com.masspick.peak.dd.controller.vo.DictionaryVO;
import com.masspick.peak.dd.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/17 0017.
 */
@Controller
@RequestMapping(value = "/dic")
public class DictionaryController extends BaseController {

    /**
     * dictionaryService
     */
    @Autowired
    private DictionaryService dictionaryService;

    /**
     * @return Object
     */
    @ResponseBody
    @GetMapping
    public Object getDic() {
        DictionaryVO dictionaryVO = new DictionaryVO();
        List<DictionaryVO> list = new ArrayList<>();
        List<Map<String, Object>> sysDictionaryList = dictionaryService.dic();
        dictionaryVO.transfer(sysDictionaryList, list);
        return renderSuccess(list);
    }
}
