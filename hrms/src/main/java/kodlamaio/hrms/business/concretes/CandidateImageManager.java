package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.imageService.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManager implements CandidateImageService {
	private CandidateImageDao candidateImageDao;
	private ImageService imageService;

	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao, ImageService imageService) {
		this.candidateImageDao = candidateImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult(Messages.candidateImageAdd);
	}

	@Override
	public Result add(CandidateImage candidateImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		String url = result.get("url");
		candidateImage.setUrl(url);
		candidateImage.setUploadedAt(LocalDate.now());
		return add(candidateImage);
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.getAllByCandidateId(candidateId));
	}
}
