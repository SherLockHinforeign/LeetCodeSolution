package TenTo19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: 
 * 		��Ŀ������һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��
 * 				ʹ�� a + b + c + d ��ֵ�� target ��ȣ��ҳ��������������Ҳ��ظ�����Ԫ�顣
 * 		���룺 nums = [1, 0, -1, 0, -2, 2]���� target = 0
 * 		�����[
 * 				[-1,  0, 0, 1],
 * 				[-2, -1, 1, 2],
 * 				[-2,  0, 0, 2]
 * 			  ]
 * 		ע�⣺���в����԰����ظ�����Ԫ��
 * 
 * @author yjx
 * @date 2020-9-15
 * @Note Commit Message �� 12λʱ���һ�� . ����Ŀ��LeetCode������202009111720.LeetCode��
 */
public class Solution18 {

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
	 * @Description: ����+˫ָ��
	 * @param 
	 * @return List<List<Integer>>
	 * @throws
	 */
	public static List<List<Integer>> solution1(int[] nums, int target) {
		/*����һ������ֵ*/
        List<List<Integer>> result=new ArrayList<>();
        /*������Ϊnull��Ԫ��С��4��ʱ��ֱ�ӷ���*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*��������д�С��������*/
        Arrays.sort(nums);
        int length=nums.length;
        /*����4��ָ��k��i��j��h  k��0��ʼ������i��k+1��ʼ����������j��h��jָ��i+1��hָ���������ֵ*/
        for(int k=0;k<length-3;k++){
            /*��k��ֵ��ǰ���ֵ���ʱ����*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*��ȡ��ǰ��Сֵ�������Сֵ��Ŀ��ֵ��˵������Խ��Խ���ֵ����ûϷ*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*��ȡ��ǰ���ֵ��������ֵ��Ŀ��ֵС��˵������Խ��ԽС��ֵ����ûϷ������*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*�ڶ���ѭ��i����ʼֵָ��k+1*/
            for(int i=k+1;i<length-2;i++){
                /*��i��ֵ��ǰ���ֵ���ʱ����*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*����ָ��jָ��i+1*/
                int j=i+1;
                /*����ָ��hָ������ĩβ*/
                int h=length-1;
                /*��ȡ��ǰ��Сֵ�������Сֵ��Ŀ��ֵ��˵������Խ��Խ���ֵ����ûϷ*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    break;
                }
                /*��ȡ��ǰ���ֵ��������ֵ��Ŀ��ֵС��˵������Խ��ԽС��ֵ����ûϷ������*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*��ʼjָ���hָ��ı��ݣ����㵱ǰ�ͣ��������Ŀ��ֵ��j++��ȥ�أ�h--��ȥ�أ�����ǰ�ʹ���Ŀ��ֵʱh--������ǰ��С��Ŀ��ֵʱj++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                       j++;
                    }
                }
            }
        }
        
        return result;
	}
}
