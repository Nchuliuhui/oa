var _url = "findAllUser";
function userPermission_Grid(){
    debugger;
    if($("#userPermission_Grid").html()!=''){
        $("#userPermission_Grid").jqGrid('setGridParam',{url:_url}).trigger('reloadGrid');
    }else{
        var params = $.extend({},jqGridParams, {
            url: _url,
            multiselect:false,
            caption:'用户列表',
            colNames:['','紧急程度','业务联系函类型','发布人','主题','业务联系函文号','日期','状态','操作'],
            colModel:[
                {name : 'ID',width : 100,align : 'center',hidden:true},//页面下钻传递的参数ID
                {name : 'URGENTLEVEL_NAME',width : 30,align : 'center',sortable : false},
                {name : 'TYPE_NAME',width : 56,align : 'center',sortable : false},
                {name : 'USER_NAME' , width : 56, align :'center',sortable : false},
                {name : 'DOCUMENT_THEME' , width : 56, align :'center',sortable : false},
                {name : 'LETTER' , width : 56, align :'center',sortable : false},
                {name : 'CREATE_TIME' , width : 56, align :'center',sortable : false},
                {name : 'NODE_NAME' , width : 56, align :'center',sortable : false},
                {name : 'CZ',width : 30,align : 'center',sortable : false,formatter:historyNotEndFormatter}
            ],
            jsonReader:$.extend({},jqGridJsonReader,{id:'userId'}),
            pager:'#userPermission_GridPager'
        });
        $("#userPermission_Grid").jqGrid(params);
        $("#userPermission_Grid").navGrid('#userPermission_GridPager',navGridParams);
        //列表操作项
        var jqGridTopStyle = {
            "padding-bottom": "100px",
            "border-top": "none",
            "background": "#eee",
            "text-align": "left"
        };
        // $("#t_selectMsgOrderPastGrid").css(jqGridTopStyle);
        // $("#t_selectMsgOrderPastGrid").append($('#selectMsgOrderPastGridToolbar').html());
        // calculateGridBodySize($("#selectMsgOrderPastGrid"),$("#t_selectMsgOrderPastGrid"),$("#selectMsgOrderPastGridPager"));

        //合并单元格 设置2级表头
        /*$( "#rectifyTimelinessAnalysisGrid" ).jqGrid( 'setGroupHeaders' , {
            useColSpanStyle :true, // 没有表头的列是否与表头列位置的空单元格合并
            groupHeaders : [
                {startColumnName : 'level1',numberOfColumns : 4,titleText : '一级预警'},
                {startColumnName : 'level2',numberOfColumns : 4,titleText : '二级预警'}
            ]
        });	*/
    }
}

$(document).ready(function() {
    debugger;
    userPermission_Grid();
    /*setTimeout(function(){
        rectifyTimelinessSearch();
        },0);*/
});	


