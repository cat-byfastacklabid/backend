CREATE TABLE public.history (
	id varchar(50) PRIMARY KEY not NULL,
	value varchar(50),
	question_type_id varchar(50) not null,
	created_by varchar(50) NOT NULL,
	created_at timestamp NOT NULL,
	updated_by varchar(50) NULL,
	updated_at timestamp NULL,
	"version" int4 default 0,
	is_active bool default true,
	CONSTRAINT history_question_fk foreign KEY (question_type) references question_type(id)
);

CREATE TABLE public.history_detail (
	id varchar(50) PRIMARY KEY not NULL,
	history_id varchar(50) not NULL,
	question_id varchar(50) not null,
	answer_id varchar(50) NOT NULL,
	value varchar(50),
	created_by varchar(50) NOT NULL,
	created_at timestamp NOT NULL,
	updated_by varchar(50) NULL,
	updated_at timestamp NULL,
	"version" int4 default 0,
	is_active bool default true,
	CONSTRAINT history_detail_fk foreign KEY (history_id) references history(id),
	CONSTRAINT question_history_fk foreign KEY (question_id) references question(id),
	CONSTRAINT answer_history_fk foreign KEY (answer_id) references answer(id)
);