package kodlamaio.hrms.core.imageService.cloudinary.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.imageService.ImageService;
import kodlamaio.hrms.core.imageService.cloudinary.CloudinaryImageManager;

@Configuration
public class CloudConfiguration {

	@Bean
	public Cloudinary cloudinaryService() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "hrmsnurhat", "api_key", "423226329842471",
				"api_secret", "TAHEQg4uv0CDFr3WChNLN_lPmns"));
	}

	@Bean
	public ImageService imageService() {
		return new CloudinaryImageManager(cloudinaryService());
	}
}
