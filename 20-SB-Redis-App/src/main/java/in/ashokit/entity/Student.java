package in.ashokit.entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@RedisHash
@Data
public class Student {

	private Integer id;
	private String name;
}
