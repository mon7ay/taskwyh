public class task1 {

    public void task1(Row[][] roww){
        int nrows = roww.length;
        int rows = roww[0].length;
        for(int i = 0;i < nrows;++i){
            for(int j = 0;j < rows;++j){
                if((roww[i][j].a == 1000 ||roww[i][j].a == 2000 ||roww[i][j].a == 3000)
                        && (roww[i][j].b >= 10 && roww[i][j].b < 50 )){
                    System.out.println(roww[i][j].a + "," + roww[i][j].b + "\n");
                    continue;
                }
                else{
                    continue;
                }
            }
        }

    }
}


