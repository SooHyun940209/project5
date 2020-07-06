package tommy.spring.board.service;

import tommy.spring.board.dao.ArticleDAO;
import tommy.spring.board.vo.ArticleVO;

public class WriteArticleServiceImpl implements WriteArticleService {

	private ArticleDAO articleDao;
	
	public WriteArticleServiceImpl() {
	}

	public WriteArticleServiceImpl(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void write(ArticleVO article) {
		System.out.println("[Service] - WriteArticleServiceImpl.write() 메소드 실행");
		articleDao.insert(article);
	}

}
