package com.dalin;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.model.User;
import com.dalin.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigData {

	@Resource
	private UserRepository ur;
	
	@Test
	public void addMoreUser() {
		
		List<User> list = new ArrayList<User>();
		User user = null;
		String[] sexarr = {"男","女","中性","未知","太监"};
		String sex = "";
		int height = 0;
		DecimalFormat df = new DecimalFormat("#.00");
		double salary = 0.0;
		boolean[] barr = {true,false};
		boolean b = true;
		String zi = "的一了是我不在人们有来他这上着个地到大里说去子得也和那要下看天时过出小么起你都把好还多没为又可家学只以主会样年想能生同老中从自面前头到它后然走很像见两用她国动进成回什边作对开而已些现山民候经发工向事命给长水几义三声于高正妈手知理眼志点心战二问但身方实吃做叫当住听革打呢真党全才四已所敌之最光产情路分总条白话东席次亲如被花口放儿常西气五第使写军吧文运在果怎定许快明行因别飞外树物活部门无往船望新带队先力完间却站代员机更九您每风级跟笑啊孩万少直意夜比阶连车重便斗马哪化太指变社似士者干石满决百原拿群究各六本思解立河爸村八难早论吗根共让相研今其书坐接应关信觉死步反处记将千找争领或师结块跑谁草越字加脚紧爱等习阵怕月青半火法题建赶位唱海七女任件感准张团屋爷离色脸片科倒睛利世病刚且由送切星晚表够整认响雪流未场该并底深刻平伟忙提确近亮轻讲农古黑告界拉名呀土清阳照办史改历转画造嘴此治北必服雨穿父内识验传业菜爬睡兴";
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		StringBuilder name = null;
		
		for (int i = 1; i < 5999999; i++) {
			user = new User();
			height = 100 + (int) Math.round(Math.random() * 100);
			salary = 10000 + Math.random() * 10000;
			sex = sexarr[(int)Math.floor(Math.random() * 5)];
			b = barr[(int)Math.floor(Math.random() * 2)];
			s1 = (int)Math.floor(Math.random() * 400);
			s2 = (int)Math.floor(Math.random() * 400);
			s3 = (int)Math.floor(Math.random() * 400);
			name = new StringBuilder();
			name.append(zi.substring(s1, s1 + 1));
			name.append(zi.substring(s2, s2 + 1));
			name.append(zi.substring(s3, s3 + 1));
			
			user.setBirthday(new Date());
			user.setHeight(height);
			user.setName(name.toString());
			salary = Double.parseDouble(df.format(salary));
			user.setSalary(salary);
			user.setSex(sex);
			user.setValidInd(b);
			list.add(user);
			System.out.println("当前个数：" + i + " 名字：" + name.toString());
			
			ur.save(user);	
		}
	}
	
}
