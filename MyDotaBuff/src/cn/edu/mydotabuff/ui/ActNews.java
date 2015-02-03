/**   
 * @Title: ActNews.java
 * @ProjectName MyDotaBuff 
 * @Package cn.edu.mydotabuff.ui 
 * @author 袁浩 1006401052yh@gmail.com
 * @date 2015-2-3 下午2:57:30 
 * @version V1.4  
 * Copyright 2013-2015 深圳市点滴互联科技有限公司  版权所有
 */
package cn.edu.mydotabuff.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import cn.edu.mydotabuff.R;
import cn.edu.mydotabuff.base.BaseActivity;
import cn.edu.mydotabuff.view.PagerSlidingTabStrip;

/**
 * @ClassName: ActNews
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 袁浩 1006401052yh@gmail.com
 * @date 2015-2-3 下午2:57:30
 * 
 */
public class ActNews extends BaseActivity {
	private static final String[] TITLE = new String[] { "全部", "刀塔新闻", "赛事资讯",
			"版本公告" };

	@Override
	protected void initViewAndData() {
		// TODO Auto-generated method stub
		setContentView(R.layout.act_news_base);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("新闻");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(
				getSupportFragmentManager());
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		PagerSlidingTabStrip indicator = (PagerSlidingTabStrip) findViewById(R.id.indicator);
		indicator.setViewPager(pager);

		// 如果我们要对ViewPager设置监听，用indicator设置就行了
		indicator.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				Toast.makeText(getApplicationContext(), TITLE[arg0],
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	@Override
	protected void initEvent() {
		// TODO Auto-generated method stub

	}

	class TabPageIndicatorAdapter extends FragmentPagerAdapter {
		public TabPageIndicatorAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// 新建一个Fragment来展示ViewPager item的内容，并传递参数
			Fragment fragment = new FragNewsItem();
			Bundle args = new Bundle();
			args.putString("arg", TITLE[position]);
			fragment.setArguments(args);

			return fragment;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLE[position % TITLE.length];
		}

		@Override
		public int getCount() {
			return TITLE.length;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
