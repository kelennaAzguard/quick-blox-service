package com.yuzee.app.quick.box;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.yuzee.app.quick.box.dto.QuickbloxChatUserWrapperDto;
import com.yuzee.app.quick.box.dto.QuickbloxUserDto;
import com.yuzee.app.quick.box.service.QuickBloxService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(classes = YuzeeAppQuickBox1Application.class)
@TestInstance(Lifecycle.PER_CLASS)
class YuzeeAppQuickBox1ApplicationTests {

	@Autowired
	protected TestRestTemplate testRestTemplate;

	private String URL = "/api/v1/quickblox/";
	@MockBean
	private QuickBloxService quickBloxService;

	@Test
	void contextLoads() {
	}

	@Test
	void createUser() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "create-user", HttpMethod.POST, entity,
				String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void updateUser() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "update-user/user/" + 123, HttpMethod.PUT,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void DeleteUser() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "delete-by-id/" + 123, HttpMethod.DELETE,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void getUserById() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "get-user-by-id/user/" + 123, HttpMethod.GET,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void getAllUser() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "/all-user", HttpMethod.GET,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void getListOfUserByFullName() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "/get-user-list-by-full-name/"+"kelenna", HttpMethod.GET,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void getListOfUserByTag() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "/get-user-list-by-tag/"+"tag", HttpMethod.GET,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void getListOfUserByLogIn() {

		QuickbloxChatUserWrapperDto QuickbloxChatUserWrapperDto = new QuickbloxChatUserWrapperDto();
		QuickbloxUserDto QuickbloxUserDto = new QuickbloxUserDto();
		QuickbloxUserDto.setFullName("new Name");
		QuickbloxUserDto.setEmail("fkelenna@gmail.com");
		QuickbloxUserDto.setId(123);
		QuickbloxUserDto.setLogin("login");
		QuickbloxUserDto.setPassword("Mamawowosani1234@");
		QuickbloxUserDto.setUpdatedAt("09078902655");
		QuickbloxUserDto.setUserTags("tag");
		QuickbloxUserDto.setUserId(UUID.randomUUID().toString());
		QuickbloxChatUserWrapperDto.setUser(QuickbloxUserDto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("userId", UUID.randomUUID().toString());
		headers.setContentType(MediaType.APPLICATION_JSON);
		Mockito.when(quickBloxService.createUser(QuickbloxChatUserWrapperDto)).thenReturn(QuickbloxChatUserWrapperDto);
		HttpEntity<QuickbloxChatUserWrapperDto> entity = new HttpEntity<>(QuickbloxChatUserWrapperDto, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(URL + "/get-user-by-login/"+"login", HttpMethod.GET,
				entity, String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
