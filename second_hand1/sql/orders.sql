CREATE TABLE orders (
	order_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
	user_id INT COMMENT '用户ID',
	order_status ENUM('pending', 'processing', 'shipped', 'delivered', 'cancelled') DEFAULT 'pending' COMMENT '订单状态',
	total_amount DECIMAL(10, 2) NOT NULL COMMENT '订单总金额',
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '订单信息表';