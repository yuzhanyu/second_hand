CREATE TABLE reports (
	report_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '举报ID',
	user_id INT COMMENT '用户ID',
	product_id INT COMMENT '商品ID',
	reason TEXT NOT NULL COMMENT '举报原因',
	status ENUM('pending', 'reviewed', 'resolved') DEFAULT 'pending' COMMENT '举报状态',
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '举报信息表';