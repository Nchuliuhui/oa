function userPermissionGrid(){
    var _url = "/findAllUser";
    if ($('#userPermission_Grid').html()!='') {
        var postData = $("#userPermission_Grid").jqGrid("getGridParam", "postData");
        $.extend(postData,sdata);
        $('#userPermission_Grid').jqGrid('setGridParam',{url:_url}).trigger('reloadGrid',[{"page":"1"}]); //重载JQGrid
    } else {
        var params = $.extend({}, jqGridParams, {
            url : _url,
            //postData:sdata,//参数类型：{name1:value1…}
            multiselect : false,//定义是否可以多选
            shrinkToFit : false,//false，则列宽度使用colModel指定的宽度
            cellEdit:false,//单元格编辑
            pginput:true,//分页输入框
            pgbuttons:true,//分页按钮
            //rowList:[],//分页数组
            height : getHeight(),
            caption : '资源分配统计',
            colNames : ['id',
                '用户名','昵称','创建时间'],
            colModel : [
                {name :'userId' , width: 120,align:'center', fixed:true,hidden:true},
                {name : 'userName',width : 60,align : 'center',sortable : false},
                {name : 'nickName',width : 60,align : 'center',sortable : false},
                {name : 'creatTime',width : 60,align : 'center',sortable : false},


            ],
            //sortname : 'dist_id,center_id,profession',
            //sortorder : 'asc',
            rowNum : '30',
            jsonReader : $.extend({}, jqGridJsonReader, {id : 'id'}),
           /// pager : '#ZyfptjGridPager'
        });
    }
}

function init() {

    userPermissionGrid();

}
$(document).ready(function() {
    init();
});