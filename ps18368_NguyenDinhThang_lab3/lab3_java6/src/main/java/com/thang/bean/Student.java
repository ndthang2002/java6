package com.thang.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@NotBlank(message="không để trống email")
	@Email(message="không đúng định dạng email")
	
	String email;
	@NotBlank(message="không để trống họ và tên")
	String fullname;
	@NotNull(message="không để trống điểm")
	@PositiveOrZero(message="điểm phải lớn hơn 0")
	@Max(value=10, message="điểm phải nhỏ hơn hoặc bằng 10")
	Double marks;
	@NotNull(message="Chọn Giới Tính!")
	Boolean gender;
	@NotBlank(message="chọn quốc tịch!")
	String country;

}
