package kodlamaio.hrms.core.utilities.resultChecker;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class ResultChecker {
	public static Result check(List<Result> results) {
		for(Result result: results) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();
	}
}
