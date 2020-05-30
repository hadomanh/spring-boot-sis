package hust.hadm;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.servers(Arrays.asList(
						new Server().url("http://localhost:8080/spring-boot-sis")
						))
				.info(new Info()
						.title("School Information System")
						.description("REST API")
						.contact(new Contact()
									.email("hadomanh99@gmail.com")
									.name("Ha Do Manh")
									.url("https://hadomanh.github.io/")
								)
						.license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")
                                )
						.version("1.0.0")
						)
				.addTagsItem(new Tag()
						.name("school")
						.description("get school infomation")
						)
				.addTagsItem(new Tag()
						.name("lecturer")
						.description("get lecturer infomation")
						)
				.addTagsItem(new Tag()
						.name("student")
						.description("get student infomation")
						)
				.addTagsItem(new Tag()
						.name("subject")
						.description("get subject infomation")
						)
				.paths(showPaths())
				;
	}
	
	private Paths showPaths() {
		return new Paths()
				// school paths
				.addPathItem("/schools/", new PathItem()
						.get(new Operation()
								.addTagsItem("school")
								.summary("Get all schools in university")
								)
						.post(new Operation()
								.addTagsItem("school")
								.summary("Add new school to university")
								.requestBody(new RequestBody()
												.required(true)
										)
								)
						)
				
				.addPathItem("/schools/{id}", new PathItem()
						.get(new Operation()
								.addTagsItem("school")
								.summary("Get school by ID")
								)
						.delete(new Operation()
								.addTagsItem("school")
								.summary("Delete school by ID")
								)
						.put(new Operation()
								.addTagsItem("school")
								.summary("Update school information")
								.addParametersItem(new Parameter()
										.name("Body")
										.in("body")
										.required(true)
										)
								
								)
						)
				.addPathItem("/schools/{id}/{entityType}/{entityId}", new PathItem()
						.delete(new Operation()
								.addTagsItem("school")
								.summary("Delete relation between school and lecturer/student")
								)
						.put(new Operation()
								.addTagsItem("school")
								.summary("Add relation between school and lecturer/student")
								)
						)
				// student path
				.addPathItem("/students/", new PathItem()
						.get(new Operation()
								.addTagsItem("student")
								.description("get all student")
								)
						)
				
				.addPathItem("/students/{id}", new PathItem()
						.get(new Operation()
								.addTagsItem("student")
								.description("get student by ID")
								)
						.delete(new Operation()
								.addTagsItem("student")
								.description("delete student by ID")
								)
						.put(new Operation()
								.addTagsItem("student")
								.description("update student information")
								.addParametersItem(new Parameter()
										.name("Body")
										.in("body")
										.required(true)
										)
								
								)
						)
				
				.addPathItem("/students/{schoolId}", new PathItem()
						.post(new Operation()
								.summary("good boy")
								.addTagsItem("student")
								.requestBody(new RequestBody()
												.required(true)
										)
								)
						)
				
				.addPathItem("/students/{id}/{subjectId}", new PathItem()
						.delete(new Operation()
								.addTagsItem("student")
								.description("delete entity relation")
								)
						.put(new Operation()
								.addTagsItem("student")
								.description("add subject relation")
								)
						)
				
				// lecturer path
				.addPathItem("/lecturers/", new PathItem()
				.get(new Operation()
						.addTagsItem("lecturer")
						.description("get all student")
						)
				)

				.addPathItem("/lecturers/{id}", new PathItem()
						.get(new Operation()
								.addTagsItem("lecturer")
								.description("get lecturer by ID")
								)
						.delete(new Operation()
								.addTagsItem("lecturer")
								.description("delete lecturer by ID")
								)
						.put(new Operation()
								.addTagsItem("lecturer")
								.description("update lecturer information")
								.addParametersItem(new Parameter()
										.name("Body")
										.in("body")
										.required(true)
										)
								
								)
						)
				
				.addPathItem("/lecturers/{schoolId}", new PathItem()
						.post(new Operation()
								.summary("good boy")
								.addTagsItem("lecturer")
								.requestBody(new RequestBody()
												.required(true)
										)
								)
						)
				
				.addPathItem("/lecturers/{id}/{subjectId}", new PathItem()
						.delete(new Operation()
								.addTagsItem("lecturer")
								.description("delete entity relation")
								)
						.put(new Operation()
								.addTagsItem("lecturer")
								.description("add subject relation")
								)
						)
				
				.addPathItem("/subjects/", new PathItem()
						.get(new Operation()
								.addTagsItem("subject")
								.description("get all subject")
								)
						.post(new Operation()
								.addTagsItem("subject")
								.description("add new subject")
								)
						)
				.addPathItem("/subjects/{id}", new PathItem()
						.get(new Operation()
								.addTagsItem("subject")
								.description("get subject information by ID")
								)
						.put(new Operation()
								.addTagsItem("subject")
								.description("update subject by ID")
								)
						.delete(new Operation()
								.addTagsItem("subject")
								.description("delete subject by ID")
								)
						)
				
				
				;
	}
	
	
}
