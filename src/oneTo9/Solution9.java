package oneTo9;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ���ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 * 		���룺 -121
 * 		�����false
 * 		ע�⣺����:���ܲ�������תΪ�ַ�����������������
 * 
 * @author yjx
 * @date 2020-9-14
 */
public class Solution9 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {

	}

	/**
	 * @Title: solution1
	 * @Description: TODO
	 * @param x
	 * @return boolean
	 * @throws
	 */
	public static boolean solution1(int x) {
		// ���������
        // ������������ x < 0 ʱ��x ���ǻ�������
        // ͬ���أ�������ֵ����һλ�� 0��Ϊ��ʹ������Ϊ���ģ�
        // �����һλ����ҲӦ���� 0
        // ֻ�� 0 ������һ����
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
        return x == revertedNumber || x == revertedNumber / 10;
	}

}
