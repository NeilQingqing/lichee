package lyt.learn.springboot;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class JsonFormatDemo {

	private int id;
	private String name;
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date createDate;
//	@JSONField(serialize=false) 这样配置会使这个字段不输出
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
