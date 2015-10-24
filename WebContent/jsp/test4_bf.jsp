<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" lang="zh-cmn-Hans" class="inner-html" id="ng-app" data-ng-app="wtApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Expires" CONTENT="0">
	<meta http-equiv="Cache-Control" CONTENT="no-cache">
	<meta http-equiv="Cache-Control" CONTENT="no-store">
	<meta http-equiv="Pragma" content="no-cache">
    <title data-ng-bind="{true:' ('+global.unread_count+') '}[global.unread_count > 0]+{true:global.title,false:'正在加载中'}[global.loading_done]+' - Worktile'"></title>
    <link rel="Shortcut Icon" ng-href="{{{true:'/img/favicon_unread.ico',false:'/img/favicon.ico'}[global.unread_count > 0]}}">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/base_common.css?ver=4.1.33">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/base_inner.css?ver=4.1.33">
    <meta name="author" content="YCTech">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="maximum-scale=1.0,width=device-width,initial-scale=1.0,user-scalable=no">
	<script src="<%=request.getContextPath() %>/assets/js/worktile.app.min.js?ver=4.1.33"></script>
	<meta name="keywords" content="团队协同,项目管理,任务管理,项目协作,在线办公,协作办公,SAAS,云协作,企业办公">
	<meta name="description" content="worktile，让工作更简单。Worktile是一个团队协同工具，通过简单的协作、沟通和分享，实现团队交互与任务管理的轻松协作。工作随身带，多平台、云数据，随时随地与团队一起工作，项目、任务、文件、话题、文档、事件、活动流、通知和日历，一个都不能少。">
    <!--[if lt IE 9]>
<script src="/shared/bower_components/html5shiv/dist/html5shiv.min.js"></script>
<script src="/shared/bower_components/respond/dest/respond.min.js"></script>
<![endif]-->
<!--[if lte IE 8]>
<script src="/shared/shared/bower_components/json2/json2.js"></script>
<script>
    document.createElement('data-ng-include');
    document.createElement('data-ng-pluralize');
    document.createElement('data-ng-view');
    document.createElement('data-ui-view');
    document.createElement('slide');
</script>
<![endif]-->

    
<script>
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F6091ae364b1e135eee2ab1cd60659210' type='text/javascript'%3E%3C/script%3E"));
</script>

</head>
<body class="ng-cloak" data-ng-cloak wt-root-paste-file>
	<div class="loading_init" ng-if="global.loading_init">
    	<span class="text">一场争论可能是两个心灵之间的捷径</span>
	</div>
	<upload-file-process></upload-file-process>
	<wt-dropwindow ng-show="$root.global.leftmenu_current_expand==='notice' || $root.global.leftmenu_current_expand==='search'"></wt-dropwindow>
	<wt-team-create ng-if="$root.global.show_team_create_modal"></wt-team-create>
	<div id="wrap-all">
	    <div id="main">
	        <div class="global_layout">
	            <div class="leftpanel">
	                <wt-leftmenu></wt-leftmenu>
	            </div>
	            <div class="centerpanel">
                <!--[if lte IE 9]>
					<div id="header_upgrade_browers" class="text-warning fade in mb_0">
					    <button data-dismiss="alert" class="close" type="button">×</button>
					    <strong>您正在使用低版本浏览器，</strong> 在本页面的显示效果可能有差异。
					    建议您升级到
					    <a href="http://www.google.cn/intl/zh-CN/chrome/" target="_blank">Chrome</a>
					    或以下浏览器：
					    <a href="www.mozilla.org/en-US/firefox/‎" target="_blank">Firefox</a> /
					    <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> /
					    <a href="http://www.opera.com/" target="_blank">Opera</a> /
					    <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie" target="_blank">
					        Internet Explorer 10</a>
					</div>
				<![endif]-->
                <data-ui-view></data-ui-view>
            </div>
        </div>
    </div>
    <wt-slide-body></wt-slide-body>
    <script type="text/ng-template" id="entity_name_link">
    <a class="target right_click_trigger" bo-title="activity.data.entity.name" href="javascript:;"
       ng-click="locator.openEntity(activity.filter.prj,activity.data.entity)"
       bo-text="activity.data.entity.name">
    </a>
	</script>
	<script type="text/ng-template" id="entity_summary_link">
    <a class="target" bo-title="activity.data.entity.name" href="javascript:;"
       bo-text="activity.data.entity.summary">
    </a>
	</script>
	<script type="text/ng-template" id="target_name_link">
    <a class="target right_click_trigger" bo-title="activity.data.target.name" href="javascript:;"
       ng-click="locator.openEntity(activity.filter.prj,activity.data.target)"
       bo-text="activity.data.target.name">
    </a>
	</script>

	<script type="text/ng-template" id="source_name_link">
    <a class="target right_click_trigger" bo-title="activity.data.source.name" href="javascript:;"
       ng-click="locator.openEntity(activity.filter.prj,activity.data.source)"
       bo-text="activity.data.source.name">
    </a>
	</script>

	<script type="text/ng-template" id="entity_avatar_link">
    <wt-avatar member="activity.data.entity" size="30" name="true" class="entity-avatar"
               avatar="activity.data.entity.image"></wt-avatar>
	</script>

<!--Task----------------------------------------------------------->
<script type="text/ng-template" id="project_task_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在列表 <strong bo-text="activity.data.target.name"></strong> 上添加新任务</span>
    <a class="target" bo-title="activity.data.entity.name" href="javascript:;" bo-text="activity.data.entity.name"></a>
</script>
<script type="text/ng-template" id="item_task_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加任务</span>
</script>

<script type="text/ng-template" id="project_task_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改任务 </span>
    <ng-include src="'source_name_link'"></ng-include>
    <span>名称为 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="item_task_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改任务</span>
    <!--<ng-include src="'source_name_link'"></ng-include>-->
    <span>名称为 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="project_task_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改任务 </span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span> 描述为 <strong bo-text="activity.data.entity.summary"></strong></span>
</script>
<script type="text/ng-template" id="item_task_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改任务</span>
    <span> 描述为 <strong bo-text="activity.data.entity.summary"></strong></span>
</script>

<script type="text/ng-template" id="project_task_member_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">分配任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    给
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_member_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">分配任务给</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>


<script type="text/ng-template" id="project_task_member_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消分配任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    给
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_member_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消分配任务给</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="project_task_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">提醒</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注任务
    <ng-include src="'target_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">提醒</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注任务
</script>

<script type="text/ng-template" id="project_task_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注任务
    <ng-include src="'target_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注任务
</script>


<script type="text/ng-template" id="project_task_complete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">完成任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_complete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">完成任务</span>
</script>

<script type="text/ng-template" id="project_task_uncomplete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消完成任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_uncomplete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消完成任务</span>
</script>

<script type="text/ng-template" id="project_task_labels_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">设置任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb">的标签</span>
    <span class="label" bo-class="activity.data.entity.summary.name+'-label'">&nbsp;</span>
    <span bo-text="activity.data.entity.summary.desc"></span>
</script>
<script type="text/ng-template" id="item_task_labels_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">设置标签</span>
    <span class="label" bo-class="activity.data.entity.summary.name+'-label'">&nbsp;</span>
    <span bo-text="activity.data.entity.summary.desc"></span>
</script>

<script type="text/ng-template" id="project_task_labels_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span>的标签</span>
    <span class="label" bo-class="activity.data.entity.summary.name+'-label'">&nbsp;</span>
    <span bo-text="activity.data.entity.summary.desc"></span>
</script>
<script type="text/ng-template" id="item_task_labels_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除标签</span>
    <span class="label" bo-class="activity.data.entity.summary.name+'-label'">&nbsp;</span>
    <span bo-text="activity.data.entity.summary.desc"></span>
</script>

<script type="text/ng-template" id="project_task_expire_set">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">设置任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb">的截止日期</span>
    <span bo-text="activity.data.entity.summary | dateFormatZHCN"></span>
</script>
<script type="text/ng-template" id="item_task_expire_set">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">设置截止日期</span>
    <span bo-text="activity.data.entity.summary | dateFormatZHCN"></span>
</script>

<script type="text/ng-template" id="project_task_expire_reset">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb">的截止日期</span>
    <span bo-text="activity.data.summary | dateFormatZHCN"></span>
</script>
<script type="text/ng-template" id="item_task_expire_reset">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消截止日期</span>
    <span bo-text="activity.data.summary | dateFormatZHCN"></span>
</script>

<script type="text/ng-template" id="project_task_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 添加文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加文件 </strong></span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="project_task_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>

</script>

<script type="text/ng-template" id="project_task_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除任务</span>
</script>

<script type="text/ng-template" id="project_task_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">重新恢复任务</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="item_task_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">重新恢复任务</span>
</script>

<script type="text/ng-template" id="item_task_move">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">从 <span ng-if="activity.data.source.old_prj">项目 <strong
            bo-text="activity.data.source.old_prj.name"></strong> </span>列表 <strong
            bo-text="activity.data.source.name"></strong> 移动任务到 列表 <strong bo-text="activity.data.target.name"></strong>
    </span>
</script>
<script type="text/ng-template" id="project_task_move">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <!--<span class="verb">移动任务</span>-->
    <ng-include src="'entity_name_link'"></ng-include>
    从 <span ng-if="activity.data.source.old_prj">项目 <strong
            bo-text="activity.data.source.old_prj.name"></strong> </span>列表 <span><strong
            bo-text="activity.data.source.name"></strong></span>
    <span>移动任务到 列表 <strong bo-text="activity.data.target.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_todo_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_todo_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上添加检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_todo_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_todo_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上删除检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_todo_check">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">完成检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_todo_check">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上完成检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_todo_uncheck">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">取消完成检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_todo_uncheck">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上取消完成检查项 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_todo_update">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改检查项 <strong bo-text="activity.data.source.name"></strong> 为
        <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_todo_update">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上修改检查项 <strong bo-text="activity.data.source.name"></strong> 为
        <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">发表了评论
        <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上发表了评论
        <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了评论
        <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_task_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在任务</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上删除了评论
        <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_task_archive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">归档了任务 </span>
</script>
<script type="text/ng-template" id="project_task_archive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">归档了任务 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>


<script type="text/ng-template" id="item_task_unarchive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">激活了任务 </span>
</script>
<script type="text/ng-template" id="project_task_unarchive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">激活了任务 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<!--Project-------------------------------------------------------->
<script type="text/ng-template" id="project_entity_name_link">
    <a class="target" bo-title="activity.data.entity.name"
       bo-href="'/project/'+activity.filter.prj" bo-text="activity.data.entity.name">
    </a>
</script>

<script type="text/ng-template" id="project_source_name_link">
    <a class="target" bo-title="activity.data.source.name"
       bo-href="'/project/'+activity.filter.prj" bo-text="activity.data.source.name"></a>
</script>

<script type="text/ng-template" id="project_target_name_link">
    <a class="target" bo-title="activity.data.target.name"
       bo-href="'/project/'+activity.filter.prj" bo-text="activity.data.target.name"></a>
</script>

<script type="text/ng-template" id="project_entity_desc_link">
    <a class="target" bo-title="activity.data.entity.name"
       bo-href="'/project/'+activity.filter.prj" bo-text="activity.data.entity.summary"></a>
</script>
<!--common tpl end -->
<script type="text/ng-template" id="project_project_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">创建项目</span>
</script>

<script type="text/ng-template" id="project_project_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改项目名为</span>
    <ng-include src="'project_entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="project_project_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改项目描述为</span>
    <ng-include src="'project_entity_desc_link'"></ng-include>
</script>

<script type="text/ng-template" id="project_project_update_logo">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改项目标识</span>
    <span bo-style="{'background':activity.data.entity.summary}">
        <i bo-class="activity.data.entity.image"></i>
    </span>
</script>

<script type="text/ng-template" id="project_project_archive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">归档项目</span>
</script>

<script type="text/ng-template" id="project_project_unarchive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">重新打开项目</span>
</script>

<script type="text/ng-template" id="project_project_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除项目</span>
</script>

<script type="text/ng-template" id="project_project_member_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加项目成员</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="project_project_member_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除项目成员</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="project_project_member_leave">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">退出了项目</span>
</script>

<script type="text/ng-template" id="project_project_member_join">
    <span class="verb">加入当前项目</span>
</script>

<!--Entry----------------------------------------------------------->

<script type="text/ng-template" id="project_entry_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加新任务列表 </span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
</script>


<script type="text/ng-template" id="project_entry_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改任务列表 </span>
    <span><strong bo-text="activity.data.source.name"></strong></span>
    <span class="verb">名称为</span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="project_entry_archive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">归档任务列表 </span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="project_entry_unarchive">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">重新打开任务列表 </span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="project_entry_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除任务列表 </span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="project_entry_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">重新恢复任务列表 </span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
</script>


<script type="text/ng-template" id="project_entry_move">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">从项目 <strong bo-text="activity.data.source.name"></strong> 移动任务列表 </span>
    <span><strong bo-text="activity.data.entity.name"></strong></span>
    <span class="verb">到项目</span>
    <span><strong bo-text="activity.data.target.name"></strong></span>
</script>
<!--File----------------------------------------------------------->
<script type="text/ng-template" id="file_name_link">
    <a class="target" bo-title="activity.data.entity.name" href="javascript:;" bo-text="activity.data.entity.name"></a>
</script>

<script type="text/ng-template" id="item_file_upload">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">上传文件 <strong bo-text="activity.data.entity.name"></strong></span>

</script>
<script type="text/ng-template" id="project_file_upload">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">上传新文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_file_new_version">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">上传新版本</span>
</script>
<script type="text/ng-template" id="project_file_new_version">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb">上传新版本</span>
</script>

<script type="text/ng-template" id="item_file_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改文件名称为</span>
    <span> <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_file_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改文件</span>
    <ng-include src="'source_name_link'"></ng-include>
    <span class="verb">名称为</span>
    <span> <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_file_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改文件描述为</span>
    <span> <strong bo-text="activity.data.entity.summary"></strong></span>
</script>
<script type="text/ng-template" id="project_file_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb">描述为</span>
    <span> <strong bo-text="activity.data.entity.summary"></strong></span>
</script>

<script type="text/ng-template" id="item_file_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除文件</span>
</script>
<script type="text/ng-template" id="project_file_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_file_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">恢复文件</span>
</script>
<script type="text/ng-template" id="project_file_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">恢复文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_file_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>

</script>
<script type="text/ng-template" id="project_file_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在文件</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_file_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_file_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在文件</span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">上删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="project_folder_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">创建了新文件夹 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_file_move">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">从 <strong bo-text="activity.data.source.name || '根目录'"></strong></span>
    <span class="verb">移动文件到 <strong bo-text="activity.data.target.name || '根目录'"></strong></span>
</script>
<script type="text/ng-template" id="project_file_move">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移动文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb">从 <strong bo-text="activity.data.source.name || '根目录'"></strong></span>
    <span class="verb">到 <strong bo-text="activity.data.target.name || '根目录'"></strong></span>
</script>

<script type="text/ng-template" id="item_file_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">提醒</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注文件
</script>
<script type="text/ng-template" id="project_file_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">提醒</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注文件
    <ng-include src="'target_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_file_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注文件
</script>
<script type="text/ng-template" id="project_file_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除</span>
    <ng-include src="'entity_avatar_link'"></ng-include>
    关注文件
    <ng-include src="'target_name_link'"></ng-include>
</script>


<!--Post----------------------------------------------------------->
<script type="text/ng-template" id="item_post_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加了话题</span>
</script>
<script type="text/ng-template" id="project_post_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加了话题 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_post_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了话题</span>
</script>
<script type="text/ng-template" id="project_post_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了话题 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_post_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改话题名称为 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_post_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改话题 </span>
    <ng-include src="'source_name_link'"></ng-include>
    <span class="verb"> 名称为 <strong bo-text="activity.data.entity.name"></strong> </span>
</script>

<script type="text/ng-template" id="item_post_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改话题内容为 <strong bo-text="activity.data.entity.summary"></strong></span>
</script>
<script type="text/ng-template" id="project_post_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改话题 </span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb"> 内容为 <strong bo-text="activity.data.entity.summary"></strong> </span>
</script>

<script type="text/ng-template" id="item_post_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_post_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在话题 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 添加关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_post_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 移除关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_post_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在话题 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 移除关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_post_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_post_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在话题 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_post_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_post_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在话题 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_post_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 恢复了话题</span>
</script>
<script type="text/ng-template" id="project_post_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 恢复了话题 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>


<script type="text/ng-template" id="item_post_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加文件 </strong></span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_post_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在话题 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 添加文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_post_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>

</script>
<script type="text/ng-template" id="project_post_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在话题 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<!--Page----------------------------------------------------------->

<script type="text/ng-template" id="item_page_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加了文档</span>
</script>
<script type="text/ng-template" id="project_page_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">添加了文档 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_page_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了文档</span>
</script>
<script type="text/ng-template" id="project_page_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了文档 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_page_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改文档名称为 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_page_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改文档 </span>
    <ng-include src="'source_name_link'"></ng-include>
    <span class="verb"> 名称为 <strong bo-text="activity.data.entity.name"></strong> </span>
</script>

<script type="text/ng-template" id="item_page_new_version">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加了新版本</span>
</script>
<script type="text/ng-template" id="project_page_new_version">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在文档 </span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb"> 上添加了新版本 </span>
</script>

<script type="text/ng-template" id="item_page_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_page_watch_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在文档 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 上添加关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_page_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 移除关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_page_watch_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在文档 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 上移除关注 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_page_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_page_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在文档 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 上发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_page_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_page_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在文档 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 上删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_page_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 恢复了文档</span>
</script>
<script type="text/ng-template" id="project_page_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 恢复了文档 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>


<script type="text/ng-template" id="item_page_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加文件 </strong></span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_page_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在文档 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 上添加文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_page_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>

</script>
<script type="text/ng-template" id="project_page_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在文档 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 上移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<!--Event----------------------------------------------------------->
<script type="text/ng-template" id="item_event_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">创建了日程</span>
</script>
<script type="text/ng-template" id="project_event_create">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">创建了日程 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_event_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改日程名称为 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_event_update_name">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改日程 </span>
    <ng-include src="'source_name_link'"></ng-include>
    <span class="verb"> 名称为 <strong bo-text="activity.data.entity.name"></strong> </span>
</script>

<script type="text/ng-template" id="item_event_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了日程</span>
</script>
<script type="text/ng-template" id="project_event_delete">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">删除了日程 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_event_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改日程描述为 <strong bo-text="activity.data.entity.summary"></strong></span>
</script>
<script type="text/ng-template" id="project_event_update_desc">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">修改日程 </span>
    <ng-include src="'entity_name_link'"></ng-include>
    <span class="verb"> 描述为 <strong bo-text="activity.data.entity.summary"></strong> </span>
</script>

<script type="text/ng-template" id="item_event_attendee_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加参与人 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_event_attendee_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在日程 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 添加参与人 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_event_attendee_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 移除参与人 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_event_attendee_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在日程 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 移除参与人 </span>
    <ng-include src="'entity_avatar_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_event_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_event_comment_add">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在日程 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 发表了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_event_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>
<script type="text/ng-template" id="project_event_comment_remove">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 在日程 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 删除了评论 <strong bo-text="activity.data.entity.name"></strong></span>
</script>

<script type="text/ng-template" id="item_event_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 恢复了日程</span>
</script>
<script type="text/ng-template" id="project_event_restore">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 恢复了日程 </span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>


<script type="text/ng-template" id="item_event_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb"> 添加文件 </strong></span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
<script type="text/ng-template" id="project_event_attach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在日程 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb"> 添加文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>

<script type="text/ng-template" id="item_event_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>

</script>
<script type="text/ng-template" id="project_event_detach_file">
    <span class="actor" bo-text="activity.actor.display_name"></span>
    <span class="verb">在日程 </span>
    <ng-include src="'target_name_link'"></ng-include>
    <span class="verb">移除文件</span>
    <ng-include src="'entity_name_link'"></ng-include>
</script>
</div>
<div id="loading" data-ng-hide="global.loading_done"></div>
<div class='notifications center-top'></div>
<iframe src="<%=request.getContextPath() %>/assets/html/blank.html" id="printFrame" marginheight="0" width="0" frameborder="0"></iframe>

<script type="text/javascript">window.wt = {};
wt.me = {
    uid               : 'd848b8783dc04feb9c5287bdedd9be82',
    name              : 'Leo_light',
    display_name      : 'Leo_light',
    email             : '934261905@qq.com',
    avatar            : '6a5468ee-92e4-4d9e-bf7c-cfce048dd1ca.jpg',
    status            : '1',
    online            : '1',
    grayscale         : '400',
    sid               : '2906b1d0dac5412da3c9e1dcb6ede324',
    is_new            : '0',
    is_bind_weixin    : '0',
    weixin_nick_name  : '',
    notice_for_desktop: '1',
    wizard            : 'false'
}; 
wt.appConfig = {
    feed_host: 'https://feed.worktile.com',
    box      : {
        wtprj_url    : 'https://wt-prj.oss.aliyuncs.com/',
        base_url     : 'https://box.worktile.com/',
        box_url_regex: '^https://box.worktile.com/(.*)$'
    }
};
</script>
</body>
</html>