CREATE TABLE order_items (
	item_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单项ID',
	order_id INT COMMENT '订单ID',
	product_id INT COMMENT '商品ID',
	quantity INT NOT NULL COMMENT '商品数量',
	price DECIMAL(10, 2) NOT NULL COMMENT '商品单价',
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '订单项详情表';