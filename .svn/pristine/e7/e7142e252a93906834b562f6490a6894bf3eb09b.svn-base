$(function () {
    initTarget();
    event();
});


function deleteTarget(Obj, node) {
    layer.confirm("确认删除该规则？", {
        btn1: function (index, layero) {
            ajaxSynch("../codeRuleController.do?deleteTarget", {targetId: Obj["targetid"]});
            node.remove();
            layer.closeAll('dialog');
        },
        btn2: function (index, layero) {

        }
    });


}

function event() {
    clickAddTarget();
}

function registerChooseBigRule() {
    $('#chooseTime').unbind().click(function () {
        showCanChooseLittleRule($(this));
    });
    $('#chooseFix').unbind().click(function () {
        showCanChooseLittleRule($(this));
    });
    $('#chooseFlow').unbind().click(function () {
        showCanChooseLittleRule($(this));
    });
}

function showCanChooseLittleRule(obj) {
    document.getElementById("chooseTime").style.backgroundColor = "#eaeaea";
    document.getElementById("chooseFix").style.backgroundColor = "#eaeaea";
    document.getElementById("chooseFlow").style.backgroundColor = "#eaeaea";
    document.getElementById("chooseTime").style.color = "#000";
    document.getElementById("chooseFix").style.color = "#000";
    document.getElementById("chooseFlow").style.color = "#000";
    document.getElementById(obj.attr("id")).style.backgroundColor = "#1d943b";
    document.getElementById(obj.attr("id")).style.color = "#fff";
    chooseLittleRule(obj.attr("id"));
    $(".littleRule").html("");
    var data = ajaxSynch("../codeRuleController.do?getLitteRule", {"type": obj.attr("opt")});
    if (!isNull($(".littleRule"), data, "没有数据，请初始化")) {
        for (var i in data)
            drawCanChooseLittle(data[i]);
    }
    registerChooseLittleRule();
}

function chooseLittleRule(classV) {
    var classs = ["chooseTime", "chooseFix", "chooseFlow"];
    for (var i in classs) {
        if (classV == classs[i]) {
            $('#' + classs[i]).addClass("ruleBeenChoose");
        } else {
            $('#' + classs[i]).removeClass("ruleBeenChoose");
        }
    }
}

function registerSaveTarget() {
    $('.saveTarget').unbind().click(function () {
        var param = getTargetObj();
        ajaxSynch("../codeRuleController.do?saveTarget", {"rule": JSON.stringify(param)});
        initTarget();
        layer.closeAll();
    });
}

function getTargetObj() {
    var result = {};
    $('.targetEditFetced input').each(function () {
        result[$(this).attr("class")] = $(this).val();
    });
    result["targetrule"] = getRuleCode();
    return result;
}

function getRuleCode() {
    var result = "";
    $('.ruleOperator .canDrag ').each(function () {
        var data = $(this).data("obj");
        console.log(data);
        result = result + data["littleruleid"] + "^" + data["typeclass"] + "^" + data["conditionalvalue"] + "^" + data["param"] + ",";
    });
    if (result != "")
        return result.substring(0, result.length - 1);
    return result;
}


function registerChooseLittleRule() {
    $('.canChooseLittle').unbind().click(function () {
        $(this).addClass("littleIsChoose");
        var $div = $('<div  class="canDrag littleIsChoose" draggable="true" ondrop="drop(event,this)" ondragover="allowDrop(event)" ondragstart="drag(event, this)">' + $(this).html() + '</div><div class="clear"></div>');
        $div.data("obj", $(this).data("obj"));
        $('.ruleOperator .clear').remove();
        $('.ruleOperator').append($div);
        registerDragLittleChange();
    });
}


function drawCanChooseLittle(data) {
    var htmlValue = data["spacer"] == "" ? "(" + data["conditionalvalue"] + ")" : "(" + data["conditionalvalue"] + "," + data["spacer"] + ")";
    var $div = $('<div class="canChooseLittle">' + data["littlerulename"] + htmlValue + '</div>');
    $div.data("obj", data);
    $('.littleRule .clear').remove();
    $('.littleRule').append($div).append($('<div class="clear"></div>'));
}

function registerDragLittleChange() {
    $(".canDrag").unbind().dblclick(function () {
        $(this).remove();
    });
}


function initTarget() {
    $('.targetValue').html("");
    var data = ajaxSynch("../codeRuleController.do?getTarget", {});
    if (!isNull($('.targetValue'), data, "目标数据为空，请初始化")) {
        for (var i in data) {
            $('.targetValue').append(getTargetValue(data[i]));
        }
        addClickForTarget();
        initTargetInput();
        dsColors();
    }
}

function initTargetInput() {
    var data = ["targetid", "targetname", "targetcode", "targetremark"];
    for (var i in data) {
        $('.targetEditFetced input' + "." + i).val("");
    }
}


function initRule(type) {
    var data = ajaxSynch("../codeRuleController.do?getLitteRule", {"type": type});
    $('.littleRuleValue').html("");
    for (var i in data) {
        $('.littleRuleValue').append(getLittleRuleValue(data[i]));
    }
}


//---------------------------util----------------------------------------

function getSubStr(str, num) {
    if (str.length <= num)
        return str;
    return str.substring(0, num) + "...";
}

function isNull(Obj, data, msg) {
    if (data.length == 0) {
        var nullInfo = $('<tr><td height="35px" colspan=1000>' + msg + '</td></tr>');
        Obj.append(nullInfo);
        return true;
    }
    return false
}

function ajaxSynch(url, data) {
    return JSON.parse($.ajax({
        type: "Post",
        url: url,
        dataType: "json",
        data: data,
        async: false,
        error: function (err) {
            console.log("ajax 调用出错 " + url);
        }
    }).responseText).result;
}

function operatorHtml(width, height, classV, add, addclassV2, delet, delclassV2, update, upclassV2) {
    var $operator = $('<table width="100%"><tr></tr></table>');
    if (add) $operator.append($('<td><div class="' + classV + ' ' + addclassV2 + ' iconfont icon-add" style="width: ' + width + 'px;height: ' + height + 'px"></div></td>'));
    if (delet) $operator.append($('<td><div class="' + classV + ' ' + delclassV2 + ' iconfont icon-del" style="width: ' + width + 'px;height: ' + height + 'px"></div></td>'));
    if (update) $operator.append($('<td><div class="' + classV + ' ' + upclassV2 + '  iconfont icon-edit" style="width: ' + width + 'px;height: ' + height + 'px"></div></td>'));
    return $operator;
}

function hiddenHtml(hidenClass) {
    var calsss = ["littleruleid", "littlerulename", "typeclass", "conditionalvalue", "spacer", "seq"];
    for (var i in calsss) {
        if ($.inArray(calsss[i], hidenClass) >= 0) {
            $('.' + calsss[i]).removeClass("isShow");
            $('.' + calsss[i]).addClass("isHiden");
        } else {
            $('.' + calsss[i]).removeClass("isHiden");
            $('.' + calsss[i]).addClass("isShow")
        }
    }
}


//--------------------------事件-----------------------------------------
function clickChangeBgColor() {
    
}

function addClickForTarget() {
    $(".delTar").unbind().click(function () {
        var data = $($(this).parents("td")[1]).data("obj");
        deleteTarget(data, $(this).parents(".showTarget"));
    })

    $(".upTar").unbind().click(function () {
        $('.addTarget').trigger("click");       //触发点击
        var data = $($(this).parents("td")[1]).data("obj");
        reviewTarget(data);                     //回显数据
    });
}

function reviewTarget(data) {
    for (var i in data) {
        $('.targetEditFetced input' + "." + i).val(data[i]);
    }
}

function registerClickBigRule() {
    $('#TimeBase').unbind().click(function () {
        document.getElementById("TimeBase").style.backgroundColor = "#1d943b";
        document.getElementById("Flow").style.backgroundColor = "#eaeaea";
        document.getElementById("Fix").style.backgroundColor = "#eaeaea";

        document.getElementById("TimeBase").style.color = "#fff";
        document.getElementById("Flow").style.color = "#000";
        document.getElementById("Fix").style.color = "#000";

        showLittleRule("TimeBase", ["littleruleid", "typeclass", "spacer", "seq"]);
        addFlagForBigRule("TimeBase");
        registerGetLittleInputValue();
    });
    $('#Flow').unbind().click(function () {
        document.getElementById("TimeBase").style.backgroundColor = "#eaeaea";
        document.getElementById("Flow").style.backgroundColor = "#1d943b";
        document.getElementById("Fix").style.backgroundColor = "#eaeaea";

        document.getElementById("TimeBase").style.color = "#000";
        document.getElementById("Flow").style.color = "#fff";
        document.getElementById("Fix").style.color = "#000";
        showLittleRule("Flow", ["littleruleid", "typeclass"]);
        addFlagForBigRule("Flow");
        registerGetLittleInputValue();
    });
    $('#Fix').unbind().click(function () {
        document.getElementById("TimeBase").style.backgroundColor = "#eaeaea";
        document.getElementById("Flow").style.backgroundColor = "#eaeaea";
        document.getElementById("Fix").style.backgroundColor = "#1d943b";

        document.getElementById("TimeBase").style.color = "#000";
        document.getElementById("Flow").style.color = "#000";
        document.getElementById("Fix").style.color = "#fff";
        showLittleRule("Fix", ["littleruleid", "typeclass", "spacer", "seq"]);
        addFlagForBigRule("Fix");
        registerGetLittleInputValue();
    })
}


function addFlagForBigRule(classV) {
    var ids = ["TimeBase", "Flow", "Fix"];
    for (var i in ids) {
        if (ids[i] == classV) {
            $('#' + ids[i]).addClass("IsBigRule");
        } else {
            $('#' + ids[i]).removeClass("IsBigRule");
        }
    }
}

function clickAddTarget() {
    $('.addTarget').unbind().click(function () {
        layer.open({
            title: '编码规则管理',
            area: ['1200px'],
            type: 1,
            content: $('#layOpen'),
            scrollbar:true,
            move:true
        });
        registerClickBigRule();
        $('#TimeBase').trigger("click");
        registerChooseBigRule();
        registerSaveTarget();
        clearInfo();
    });

}

function clearInfo() {
    var data = ["targetid", "targetname", "targetcode", "targetremark"];
    for (var i in data) {
        $('.targetEditFetced input' + "." + data[i]).val("");
    }
}

function showLittleRule(type, hiddenClass) {
    initRule(type);
    addLittleInput("littleRuleValue");
    hiddenHtml(hiddenClass);
}

function registerGetLittleInputValue() {
    $('.addLittle').unbind().click(function () {
        if (!checkInputIsNull()) {
            var result = {};
            $('#addTr input').each(function () {
                result[$(this).attr("opt")] = $(this).val();
            });
            result["typeclass"] = $('.IsBigRule').attr("id");
            ajaxSynch("../codeRuleController.do?saveLittleRule", {"littleRule": JSON.stringify(result)});
            $('.IsBigRule').trigger("click");
        } else {
            layer.msg('请输入完全在选择保存');
        }
    });

    $('.delLittle').unbind().click(function () {
        var id = $(this).parents(".showLittle").find(".littleruleid").html();
        layer.confirm("确认删除该规则？", {
            btn1: function (index, layero) {
                ajaxSynch("../codeRuleController.do?deleteLittleRule", {"littleRuleId": id});
                $('.IsBigRule').trigger("click");
                layer.closeAll('dialog');
            },
            btn2: function (index, layero) {

            }
        });
    });
}


function checkInputIsNull() {
    var result = false;
    $('#addTr input.isShow').each(function () {
        if ($.trim($(this).val()) == "") {
            if ($(this).attr("opt") != "param") {
                result = true;
                return;
            }
        }
    });
    return result;
}


//-----------------------------数据处理-----------------------------------
function dsColors() {
    var table = document.getElementById("targetTable");
    var rows = table.getElementsByTagName("tr");

    for (var i = 0; i < rows.length; i++) {
        if (i % 4 == 0) {
            rows[i].style.backgroundColor = "#f6f1fa";
        } else {
            rows[i].style.backgroundColor = "White";
        }
    }
}
// 悬浮每一行
function changebg(obj, cl) {
    var bgcolor;
    if (cl == "0") {
        bgcolor = "#d2e6f6";
    }
    else if(cl == "1"){
        dsColors();
    }else{
        bgcolor = "#fbec88";
    }

    obj.style.backgroundColor = bgcolor;


}

function getTargetValue(data) {
    var $tr = $(' <tr class="showTarget" onclick="changebg(this,2)" onmousemove="javascript:changebg(this,0);" onmouseout="javascript:changebg(this,1);"> <td height="35px">' + data["targetcode"] + '</td><td>' + data["targetname"]
        + '</td> <td title="' + data["targetrule"] + '">' + getSubStr(data["targetrule"], 20)
        + '</td> <td>' + data["createname"] + '</td> <td>' + data["createtime"]
        + '</td><td title="' + data["targetremark"]
        + '">' + getSubStr(data["targetremark"], 10) + '</td></tr>');
    var $operator = $('<td></td>');
    $operator.append(operatorHtml(20, 20, "operatorDiv", false, "addTar", true, "delTar", true, "upTar"));
    $operator.data("obj", data);

    return $tr.append($operator);
}

function getLittleRuleValue(data) {
    var $tr = $('<tr class="showLittle"><td class="littleruleid">' + data["littleruleid"] + '</td>' +
        '<td class="littlerulename" width="40px" title="'+ data["littlerulename"] +'">' + data["littlerulename"] + '</td>' +
        '<td class="typeclass">' + data["typeclass"] + '</td>' +
        '<td class="conditionalvalue">' + data["conditionalvalue"] + '</td>' +
        '<td class="spacer">' + data["spacer"] + '</td><td class="seq">' + data["seq"] + '</td>' +
        '<td class="param">' + data["param"] + '</td></tr>')
    var $operator = $('<td></td>');
    $operator.append(operatorHtml(20, 20, "operatorDiv", false, "addTar", true, "delLittle", false, "upTar"));
    $operator.data("obj", data);
    return $tr.append($operator);
}

function addLittleInput(classV) {
    var $tr = $('<tr id="addTr"><td class="littleruleid">' +
        '<input class="littleruleid" opt="littleruleid" style="width: 40px"></td>' +
        '<td class="littlerulename"><input class="littlerulename" opt="littlerulename" ' +
        'style="width: 94%" ></td></td>' +
        '<td class="typeclass"><input class="typeclass" opt="typeclass" style="width: 94%" ></td>' +
        '<td class="conditionalvalue">' +
        '<input class="conditionalvalue" opt="conditionalvalue" style="width: 94%" ></td>' +
        '<td class="spacer"><input class="spacer" opt="spacer" style="width: 94%" ></td>' +
        '<td class="seq"><input class="seq" opt="seq" style="width: 94%" ></td>' +
        '<td class="param"><input class="param" opt="param" style="width: 94%" ></td></tr>');
    var $operator = $('<td></td>');
    $operator.append(operatorHtml(20, 20, "operatorDiv", true, "addLittle", false, "delLittle", false, "upTar"));
    $('.' + classV).append($tr.append($operator));
}


function allowDrop(ev) {
    ev.preventDefault();
}

var srcdiv = null;

function drag(ev, divdom) {      //拖
    srcdiv = divdom;
    var info = $(divdom).data("obj");
    ev.dataTransfer.setData("text/html", divdom.innerHTML);  //获取里面的值
}

function drop(ev, divdom)       //放
{
    ev.preventDefault();
    if (srcdiv != divdom) {
        srcdiv.innerHTML = divdom.innerHTML;
        divdom.innerHTML = ev.dataTransfer.getData("text/html");

        var tmp = $(divdom).data("obj");
        $(divdom).data("obj", $(srcdiv).data("obj"));
        $(srcdiv).data("obj", tmp);
    }
}


