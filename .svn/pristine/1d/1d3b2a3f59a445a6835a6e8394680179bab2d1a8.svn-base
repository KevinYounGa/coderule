package coderule1.controller;

import coderule1.dal.model.CodeLittlerule;
import coderule1.dal.model.CodeTarget;
import coderule1.dal.service.ServiceDao;
import coderule1.dal.util.RuleDao;
import coderule1.dal.util.TargetDao;
import coderule1.util.target.TargetUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by fangiming on 2017/9/19.
 */
@Controller
@RequestMapping("/codeRuleController")
public class CodeRuleController implements CodeRuleControllerInt {

    @Autowired
    private TargetUtil target;

    @Autowired
    private RuleDao ruleDao;

    @Autowired
    private TargetDao targetDao;

    @Autowired
    private ServiceDao serviceDao;


    @RequestMapping(params = "getTarget",produces = "text/json;charset=UTF-8")
    public @ResponseBody Object getTarget(){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",target.getAllTarget());
        return result;
    }

    @RequestMapping(params = "getLitteRule",produces = "text/json;charset=UTF-8")
    public @ResponseBody Object getLitteRule(@RequestParam("type") String type){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",ruleDao.getLittleCodeByType(type));
        return result;
    }

    @RequestMapping(params = "saveLittleRule",produces = "text/json;charset=UTF-8")
    public @ResponseBody Object saveLittleRule(@RequestParam("littleRule") String little){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",ruleDao.saveRuleLittle(JSONObject.parseObject(little, CodeLittlerule.class)));
        return result;
    }

    @RequestMapping(params = "deleteLittleRule",produces = "text/json;charset=UTF-8")
    public @ResponseBody Object deleteLittleRule(@RequestParam("littleRuleId") Integer littleRuleId){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",ruleDao.deleteRuleLittle(littleRuleId));
        return result;
    }

    @RequestMapping(params = "saveTarget",produces = "text/json;charset=UTF-8")
     public @ResponseBody Object saveTarget(@RequestParam("rule") String rule){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",targetDao.saveTarget(JSONObject.parseObject(rule, CodeTarget.class)));
        return result;
    }

    @RequestMapping(params = "deleteTarget",produces = "text/json;charset=UTF-8")
    public @ResponseBody Object deleteTarget(@RequestParam("targetId") Integer targetId){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",targetDao.deleteTarget(targetId));
        return result;
    }

    @RequestMapping(params = "getCode",produces = "text/json;charset=UTF-8")
    public @ResponseBody Object getCode( @RequestParam("targetInfo") String targetInfo){
        JSONObject result=new JSONObject();
        result.put("code",1);
        result.put("result",serviceDao.getCodeValue(JSONObject.parseObject(targetInfo)));
        return result;
    }

    /**
     * 测试文件上传
     */
    @RequestMapping(params = "fileUpload")
    public @ResponseBody Object fileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request){
        try{
            String path="D:/"+file.getOriginalFilename();
            File newFile=new File(path);
            file.transferTo(newFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "true";
    }

    //codeRuleController.do?testPage
    @RequestMapping(params = "testPage")
    public ModelAndView testPage(){
        return new ModelAndView("https\\://www.baidu.com/");
    }

}
