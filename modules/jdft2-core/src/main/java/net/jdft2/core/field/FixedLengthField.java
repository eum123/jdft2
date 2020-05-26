package net.jdft2.core.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FixedLengthField {
	/* 필드 전체 길 */
	int size() default 0;
	
	/* 데이터 type */
	DataType dataType() default DataType.STRING;
	
	/* padding */
	Padding padding() default Padding.LEFT;
	
	/* padding 구분자 */
	char paddingDelimitor() default ' ';
	
}