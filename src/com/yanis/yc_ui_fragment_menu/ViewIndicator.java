package com.yanis.yc_ui_fragment_menu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author YeChao
 * @�����������Զ���ײ�������
 *
 */
public class ViewIndicator extends LinearLayout implements OnClickListener {
	private int mDefaultIndicator = 0; // Ĭ�ϵ�ѡ��View

	private static int mCurIndicator; // ��ǰѡ��View

	private static View[] mIndicators; // View����

	private OnIndicateListener mOnIndicateListener; // ��Ӧ�ļ�����
	// ��Ӧ��ͼ��Tag
	private static final String TAG_ICON_0 = "icon_tag_0";
	private static final String TAG_ICON_1 = "icon_tag_1";
	private static final String TAG_ICON_2 = "icon_tag_2";
	private static final String TAG_ICON_3 = "icon_tag_3";
	private static final String TAG_ICON_4 = "icon_tag_4";
	// ��Ӧ������Tag
	private static final String TAG_TEXT_0 = "text_tag_0";
	private static final String TAG_TEXT_1 = "text_tag_1";
	private static final String TAG_TEXT_2 = "text_tag_2";
	private static final String TAG_TEXT_3 = "text_tag_3";
	private static final String TAG_TEXT_4 = "text_tag_4";
	// δѡ��״̬
	private static final int COLOR_UNSELECT = Color.argb(100, 0xff, 0xff, 0xff);
	// ѡ��״̬
	private static final int COLOR_SELECT = Color.WHITE;

	// ���캯��
	public ViewIndicator(Context context) {
		super(context);
	}

	public ViewIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		mCurIndicator = mDefaultIndicator;
		setOrientation(LinearLayout.HORIZONTAL);// ˮƽ����
		init();
	}

	/**
	 * �˵���ͼ����
	 * 
	 * @param iconResID
	 *            ͼƬ��ԴID
	 * @param stringResID
	 *            ������ԴID
	 * @param stringColor
	 *            ��ɫ��ԴID
	 * @param iconTag
	 *            ͼƬ��ǩ
	 * @param textTag
	 *            ���ֱ�ǩ
	 * @return
	 */
	private View createIndicator(int iconResID, int stringResID,
			int stringColor, String iconTag, String textTag) {
		// ʵ��һ��LinearLayout
		LinearLayout view = new LinearLayout(getContext());
		view.setOrientation(LinearLayout.VERTICAL);// ��ֱ����
		// ���ÿ�ߺ�Ȩ��
		view.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
		view.setGravity(Gravity.CENTER_HORIZONTAL);
		view.setBackgroundResource(R.drawable.main_tab_item_bg_normal);
		// ʵ��һ��ImageView
		ImageView iconView = new ImageView(getContext());
		// �������ImageView��ͼ������ı��
		iconView.setTag(iconTag);
		// ���ÿ�ߺ�Ȩ��
		iconView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
		iconView.setImageResource(iconResID);// ����ͼƬ��Դ
		// ʵ��һ��TextView
		TextView textView = new TextView(getContext());
		// �������TextView��ͼ������ı��
		textView.setTag(textTag);
		// ���ÿ�ߺ�Ȩ��
		textView.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
		// ����������ɫ
		textView.setTextColor(stringColor);
		// �������ִ�С
		textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
		// ����������Դ
		textView.setText(stringResID);
		// �����ͼ��������
		view.addView(iconView);
		view.addView(textView);
		// ���ز�����ͼ
		return view;

	}

	/**
	 * ��ʼ����ͼ
	 */
	private void init() {
		mIndicators = new View[5];// 5��View
		// ��һ��ΪĬ��ѡ�е�
		// ��ҳmain_tab_item_bg_normal
		mIndicators[0] = createIndicator(R.drawable.main_tab_item_home_focus,
				R.string.tab_item_home, COLOR_SELECT, TAG_ICON_0, TAG_TEXT_0);
		mIndicators[0].setBackgroundResource(R.drawable.main_tab_item_bg);
		mIndicators[0].setTag(Integer.valueOf(0));
		mIndicators[0].setOnClickListener(this);
		addView(mIndicators[0]);
		// ����
		mIndicators[1] = createIndicator(
				R.drawable.main_tab_item_category_normal,
				R.string.tab_item_category, COLOR_UNSELECT, TAG_ICON_1,
				TAG_TEXT_1);
		mIndicators[1].setBackgroundResource(R.drawable.main_tab_item_bg);
		mIndicators[1].setTag(Integer.valueOf(1));
		mIndicators[1].setOnClickListener(this);
		addView(mIndicators[1]);
		// ����
		mIndicators[2] = createIndicator(R.drawable.main_tab_item_down_normal,
				R.string.tab_item_down, COLOR_UNSELECT, TAG_ICON_2, TAG_TEXT_2);
		mIndicators[2].setBackgroundResource(R.drawable.main_tab_item_bg);
		mIndicators[2].setTag(Integer.valueOf(2));
		mIndicators[2].setOnClickListener(this);
		addView(mIndicators[2]);
		// �ҵ�
		mIndicators[3] = createIndicator(R.drawable.main_tab_item_user_normal,
				R.string.tab_item_user, COLOR_UNSELECT, TAG_ICON_3, TAG_TEXT_3);
		mIndicators[3].setBackgroundResource(R.drawable.main_tab_item_bg);
		mIndicators[3].setTag(Integer.valueOf(3));
		mIndicators[3].setOnClickListener(this);
		addView(mIndicators[3]);
		// ����
		mIndicators[4] = createIndicator(
				R.drawable.main_tab_item_setting_normal,
				R.string.tab_item_setting, COLOR_UNSELECT, TAG_ICON_4,
				TAG_TEXT_4);
		mIndicators[4].setBackgroundResource(R.drawable.main_tab_item_bg);
		mIndicators[4].setTag(Integer.valueOf(4));
		mIndicators[4].setOnClickListener(this);
		addView(mIndicators[4]);
	}

	public static void setIndicator(int which) {
		// /////////////////���֮ǰ��״̬/////////////////////////////////
		// mIndicators[mCurIndicator].setBackgroundResource(R.drawable.main_tab_item_bg_normal);
		ImageView prevIcon;
		TextView prevText;
		switch (mCurIndicator) {
		case 0:
			prevIcon = (ImageView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_ICON_0);
			prevIcon.setImageResource(R.drawable.main_tab_item_home);
			prevText = (TextView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_TEXT_0);
			prevText.setTextColor(COLOR_UNSELECT);
			break;
		case 1:
			prevIcon = (ImageView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_ICON_1);
			prevIcon.setImageResource(R.drawable.main_tab_item_category);
			prevText = (TextView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_TEXT_1);
			prevText.setTextColor(COLOR_UNSELECT);
			break;
		case 2:
			prevIcon = (ImageView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_ICON_2);
			prevIcon.setImageResource(R.drawable.main_tab_item_down);
			prevText = (TextView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_TEXT_2);
			prevText.setTextColor(COLOR_UNSELECT);
			break;
		case 3:
			prevIcon = (ImageView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_ICON_3);
			prevIcon.setImageResource(R.drawable.main_tab_item_user);
			prevText = (TextView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_TEXT_3);
			prevText.setTextColor(COLOR_UNSELECT);
			break;
		case 4:
			prevIcon = (ImageView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_ICON_4);
			prevIcon.setImageResource(R.drawable.main_tab_item_setting);
			prevText = (TextView) mIndicators[mCurIndicator]
					.findViewWithTag(TAG_TEXT_4);
			prevText.setTextColor(COLOR_UNSELECT);
			break;
		}
		// /////////////////����ǰ״̬/////////////////////////////////
		// mIndicators[which].setBackgroundResource(R.drawable.main_tab_item_bg_focus);
		ImageView currIcon;
		TextView currText;
		/**
		 * ����ѡ��״̬
		 */
		switch (which) {
		case 0:
			currIcon = (ImageView) mIndicators[which]
					.findViewWithTag(TAG_ICON_0);
			currIcon.setImageResource(R.drawable.main_tab_item_home_focus);
			currText = (TextView) mIndicators[which]
					.findViewWithTag(TAG_TEXT_0);
			currText.setTextColor(COLOR_SELECT);
			break;
		case 1:
			currIcon = (ImageView) mIndicators[which]
					.findViewWithTag(TAG_ICON_1);
			currIcon.setImageResource(R.drawable.main_tab_item_category_focus);
			currText = (TextView) mIndicators[which]
					.findViewWithTag(TAG_TEXT_1);
			currText.setTextColor(COLOR_SELECT);
			break;
		case 2:
			currIcon = (ImageView) mIndicators[which]
					.findViewWithTag(TAG_ICON_2);
			currIcon.setImageResource(R.drawable.main_tab_item_down_focus);
			currText = (TextView) mIndicators[which]
					.findViewWithTag(TAG_TEXT_2);
			currText.setTextColor(COLOR_SELECT);
			break;
		case 3:
			currIcon = (ImageView) mIndicators[which]
					.findViewWithTag(TAG_ICON_3);
			currIcon.setImageResource(R.drawable.main_tab_item_user_focus);
			currText = (TextView) mIndicators[which]
					.findViewWithTag(TAG_TEXT_3);
			currText.setTextColor(COLOR_SELECT);
			break;
		case 4:
			currIcon = (ImageView) mIndicators[which]
					.findViewWithTag(TAG_ICON_4);
			currIcon.setImageResource(R.drawable.main_tab_item_setting_focus);
			currText = (TextView) mIndicators[which]
					.findViewWithTag(TAG_TEXT_4);
			currText.setTextColor(COLOR_SELECT);
			break;
		}

		mCurIndicator = which;
	}

	public interface OnIndicateListener {
		public void onIndicate(View v, int which);
	}

	public void setOnIndicateListener(OnIndicateListener listener) {
		mOnIndicateListener = listener;
	}

	@Override
	public void onClick(View v) {
		if (mOnIndicateListener != null) {
			int tag = (Integer) v.getTag();
			switch (tag) {
			case 0:
				if (mCurIndicator != 0) {
					mOnIndicateListener.onIndicate(v, 0);
					setIndicator(0);
				}
				break;
			case 1:
				if (mCurIndicator != 1) {
					mOnIndicateListener.onIndicate(v, 1);
					setIndicator(1);
				}
				break;
			case 2:
				if (mCurIndicator != 2) {
					mOnIndicateListener.onIndicate(v, 2);
					setIndicator(2);
				}
				break;
			case 3:
				if (mCurIndicator != 3) {
					mOnIndicateListener.onIndicate(v, 3);
					setIndicator(3);
				}
				break;
			case 4:
				if (mCurIndicator != 4) {
					mOnIndicateListener.onIndicate(v, 4);
					setIndicator(4);
				}
				break;
			default:
				break;
			}
		}
	}
}
