# hzero-order-25107
## 项目信息
* 简介：上海汉得信息技术股份有限公司 Hzero考核 (销售订单)
* 部门：管理会计事业部
* 姓名：聂飞
* 工号：25107
    
## 概述

#### 开发目的
   通过该考核来测试培训人员对Hzero的掌握情况。

#### 开发内容
   开发一个销售订单管理平台，来查询、录入、编辑、导出销售订单信息及销售订单报表等。

#### 开发框架
   Hzero (0.10.0)

#### 开发环境
* MySQL5.7
* Redis
* JDK1.8

#### 开发列表
1. 销售订单汇总查询页面
2. 录入、编辑、查看销售订单页面(含编码规则使用、附件处理)
3. 导出销售订单信息至Excel
4. 销售订单定时关闭
5. 销售订单单据报表打印（选做）
6. 销售订单Excel导入（选做）
7. 工作流订单审批（选做）
8. 按钮权限控制

#### 数据库设计
* 公司主数据：hodr_company
   * 表设计：[hodr_company](img/hodr_company.png)
   * 索引：[hodr_company_index](img/hodr_company_index.png)
* 客户主数据：hodr_customer
   * 表设计：[hodr_customer](img/hodr_customer.png)
   * 索引：[hodr_customer_index](img/hodr_customer_index.png)
* 物料主数据：hodr_item
   * 表设计：[hodr_item](img/hodr_item.png)
   * 索引：[hodr_item_index](img/hodr_item_index.png)
* 业务主数据：hodr_so_header（存放销售订单头信息）
   * 表设计：[hodr_so_header](img/hodr_so_header.png)
   * 索引：[hodr_so_header_index](img/hodr_so_header_index.png)
* 业务主数据：hodr_so_line（存放销售订单行信息）
   * 表设计：[hodr_so_line](img/hodr_so_line.png)
   * 索引：[hodr_so_line_index](img/hodr_so_line_index.png)

#### 实现功能
* 基于查询公司、客户、销售订单号、物料、订单状态查询销售订单数据
* 查询订单数据
* 导出订单数据（基于 Excel）
* 实现新增/更改/查看销售订单，禁止销售订单被删除
* 销售订单自动关闭功能

#### 启动说明
1. 新建数据库hzero_order
2. 运行[hzero_order_25107.sql](hzero_order_25107.sql)文件，新建数据表，导入数据
3. 依照[Hzero本地部署说明](img/Hzero本地安装部署.pdf)搭建Hzero开发环境
4. Hzero本地部署完成，依次启动Hzero服务。打开eureka查看服务启动情况
5. 修改本项目[application.yml](src/main/resources/application.yml)文件中MySQL数据库地址、用户名、密码
6. 修改本项目[application.yml](src/main/resources/application.yml)文件中注册中心地址
7. 修改本项目[bootstrap.yml](src/main/resources/bootstrap.yml)文件中配置中心地址
8. 启动服务，打开Swagger查看接口详情

#### 接口说明
* /v1/orders-total/{organizationId}/query-orders
   <p>根据多条件查询订单信息</p>
* /v1/orders-total/{organizationId}/page-company
   <p>分页查询公司信息</p>
* /v1/orders-total/{organizationId}/page-customer
   <p>分页查询客户信息</p>
* /v1/orders-total/{organizationId}/page-item
   <p>分页查询客户信息</p>
* /v1/orders-total/{organizationId}/export-orders
   <p>导出订单数据</p>

* /v1/orders-detail/{organizationId}/query-order-and-line
   <p>查看单个订单的详细信息</p>
* /v1/orders-detail/{organizationId}/create-one-order
   <p>新增一条订单头信息及其相关行信息</p>
* /v1/orders-detail/{organizationId}/update-one-order
   <p>修改一条订单头信息及其相关行信息</p>
