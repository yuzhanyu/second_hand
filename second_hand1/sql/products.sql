CREATE TABLE products (
	product_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品ID',
	merchant_id INT COMMENT '商家ID',
	name VARCHAR(100) NOT NULL COMMENT '商品名称',
	description TEXT COMMENT '商品描述',
	price DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
	stock INT NOT NULL COMMENT '库存数量',
	category_id INT COMMENT '分类ID',
	status ENUM('active', 'inactive') DEFAULT 'active' COMMENT '商品状态',
	create_by INT COMMENT '创建人',
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by INT COMMENT '修改人',
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '商品信息表';