CREATE TABLE categories (
	category_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '分类ID',
	name VARCHAR(50) NOT NULL UNIQUE COMMENT '分类名称',
	description VARCHAR(255) COMMENT '分类描述',
	create_by INT COMMENT '创建人',
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_by INT COMMENT '修改人',
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT '商品分类表';