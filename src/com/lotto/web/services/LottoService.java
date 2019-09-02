package com.lotto.web.services;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	
	
	public void createLotto(LottoBean param);
	public String createBall();
	public String createSeq();
	public String createNum();
	public boolean duplicateInspection(int[] arr , int a);
	public String[] descendingOrder();
	
}


