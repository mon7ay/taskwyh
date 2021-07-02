import java.util.ArrayList;
import java.util.List;

public class task3 {
    //找出list中符合b < 50的最后一个元素的下标
    public int findEndIndex(List<Row> list){
        int size = list.size();
        int pivot = size/2;
        while(list.get(pivot).b >= 50 ){
            pivot = pivot/2;
            if(pivot == 0){
                return -1;
            }
        }
        if(list.get(pivot).b <10){
            return -1;
        }
        else{
            while(list.get(pivot).b <= 50){
                pivot++;
            }
            return pivot-1;
        }
    }
    //找出list中符合b >= 10的第一个元素的下标
    public int findStartIndex(List<Row> list){
        int size = list.size();
        int pivot = size/2;
        while(list.get(pivot).b < 10 ){
            pivot = pivot*2;
            if(pivot >= size){
                return -1;
            }
        }
        if(list.get(pivot).b >= 50){
            return -1;
        }
        else{
            while(list.get(pivot).b > 10){
                pivot--;
            }
            return pivot+1;
        }
    }

    //循环输出打印函数
    public void Psout(List<Row> list,int start,int end){
        for(int i = start;i < end;++i){
            System.out.println(list.get(i).a + "," + list.get(i).b + "\n");
        }
    }

    //把r1/r2/r3中的元素加入到rf中
    public void addrf(List<Row> rf,List<Row> r,int start,int end){
        for(int i = start;i < end;++i){
            rf.add(r.get(i));
        }
    }
    //冒泡排序，以实现按b排序，且b相同是按a排序
    public void sort(List<Row> rf){
        int size = rf.size();
        for(int i =0;i < size -1;++i ){
            for(int j = size -1 ;j > i;--j ){
                if(rf.get(j).b < rf.get(j - 1).b){
                    int temp = rf.get(j).b;
                    rf.get(j).b = rf.get(j-1).b;
                    rf.get(j-1).b =temp;
                }
            }

        }


    }

    public void task1(Row[][] roww){
        int nrows = roww.length;
        int rows = roww[0].length;
        for(int i = 0;i < nrows;++i){
            for(int j = 0;j < rows;++j){

                if(roww[i][j].a > 3000){
                    break;
                }

                List<Row> r1 = new ArrayList<>();
                List<Row> r2 = new ArrayList<>();
                List<Row> r3 = new ArrayList<>();

                if(roww[i][j].a == 1000 ||roww[i][j].a == 2000 ||roww[i][j].a == 3000){
                    switch (roww[i][j].a){
                        case 1000:
                            r1.add(roww[i][j]);
                            break;
                        case 2000:
                            r2.add(roww[i][j]);
                            break;
                        default:
                            r3.add(roww[i][j]);
                            break;
                    }
                }

                int sr1 = findStartIndex(r1);
                int sr2 = findStartIndex(r2);
                int sr3 = findStartIndex(r3);
                int er1 = findEndIndex(r1);
                int er2 = findEndIndex(r2);
                int er3 = findEndIndex(r3);

                List<Row> rf = new ArrayList<>();
                addrf(rf,r1,sr1,er1);
                addrf(rf,r2,sr2,er3);
                addrf(rf,r3,sr3,er3);

                sort(rf);
                Psout(rf,0,rf.size()-1);





            }
        }

    }
}
