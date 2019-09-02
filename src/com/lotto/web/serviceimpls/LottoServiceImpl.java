package com.lotto.web.serviceimpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lotto.web.daoimpls.LottoDAOImpl;
import com.lotto.web.daos.LottoDAO;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoService;

public class LottoServiceImpl implements LottoService {
	private LottoDAO dao;
	
	public LottoServiceImpl() {
		dao = new LottoDAOImpl();
	}

	@Override
	public void createLotto(LottoBean param) {
		param.setLotteryNum(createNum());
		param.setLottoSeq(createSeq());
		dao.insertLotto(param);
	}


	public String createBall() {
		String ball = "";
		Random ran = new Random();
		ball = String.valueOf(ran.nextInt(45)+1);
		return ball;
	}


	public String createSeq() {
		String seq = "";
		Random ran = new Random();
		seq = String.format("No.%04d", ran.nextInt(9999)+1);
		return seq;
	}


	public String createNum() {
		Random ran = new Random();
		String lotto = "";
		int a = 0;
		int[] arr = new int[6];
		for(int i = 0;i<6;i++) {
			a = ran.nextInt(45)+1;
			if(duplicateInspection(arr, a)) {
				arr[i] = a;
			}
		}
		
		for(int i = 0;i<6;i++) {
			if(i==5) {
				lotto += String.valueOf(arr[i]);
			}else {
				lotto += String.valueOf(arr[i])+",";
			}
		}
		
		return lotto;
	}

	
	@Override
	public boolean duplicateInspection(int[] arr , int a) {
		boolean b = true;
		for(int i = 0; i <6; i++) {
			if(arr[i] == a) {
				b = false;
			}
		}
		return b;
	}
			
		
		

	

	
	@Override
	public String[] descendingOrder() {
		String[] arr = createNum().split(",");
		int[] arr2 = new int[6];
		for(int i = 0; i < 6 ; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		
		for(int j = 0;j<6;j++) {
			for(int k = 0;k<6;k++) {
				if(arr2[k]<arr2[k+1]) {
					int temp = arr2[k];
					arr2[k] = arr2[k+1];
					arr2[k+1] = temp;
				}
			}
		}
		
		
		return arr;
	}
	
	
	
	

}
