<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <security:authentication property="principal.username"></security:authentication>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/pages/main.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="admin-profile">
                        <a href="${pageContext.request.contextPath}/user/findAll/1/5">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                    <li id="admin-invoice">
                        <a href="${pageContext.request.contextPath}/role/findAll/1/5">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                    </li>

                    <li id="admin-invoice-print">
                        <a href="${pageContext.request.contextPath}/premission/findAll/1/5">
                            <i class="fa fa-circle-o"></i> 资源权限管理管理
                        </a>
                    </li>

                    <li id="admin-dataform">
                        <a href="">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a>
                    </li>

                </ul>
            </li>



            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i> <span>数据管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="charts-flot">
                        <a href="${pageContext.request.contextPath}/product/findAll/1/5">
                            <i class="fa fa-circle-o"></i> 商品管理
                        </a>
                    </li>

                    <li id="charts-inline">
                        <a href="${pageContext.request.contextPath}/order/findAll?page=1&size=5">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
</body>
</html>
