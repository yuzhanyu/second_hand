CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
	username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
	password_hash VARCHAR(255) NOT NULL COMMENT '密码哈希值',
	email VARCHAR(100) NOT NULL UNIQUE COMMENT '邮箱',
	phone VARCHAR(20) COMMENT '电话号码',
	address VARCHAR(255) COMMENT '地址',
	status ENUM('active', 'inactive', 'banned') DEFAULT 'active' COMMENT '用户状态',
	create_by INT COMMENT '创建人',
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by INT COMMENT '修改人',
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '用户信息表';