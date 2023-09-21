import java.util.*;
import java.io.*;

//package OGraph;
//package NOGraph;
//package MGraph;

public class Program
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);

        int action1 = 0;
        int action2 = 0;
        boolean eFlag1 = false;
        boolean eFlag2 = false;

        List<Graph> graphBase = new ArrayList<>();

        while (!eFlag1)
        {
            System.out.println("Введите что будете делать:");
            System.out.println("1 - Создать пустой ориентированный граф.");
            System.out.println("2 - Создать пустой неориентированный граф.");
            System.out.println("3 - Создать пустой смешаный граф.");
            System.out.println("4 - Создать копию графа.");
            System.out.println("5 - Содать граф на основе файла.");
            System.out.println("6 - Создать файл на основе графа.");
            System.out.println("7 - Изменить граф из базы.");
            System.out.println("6 - Вывести информацию о всех графах.");
            System.out.println("9 - Отформатировать базу.");
            System.out.println("10 - Выйти из программы.");

            action1 = in.nextInt() - 1;

            switch(action1)
            {
                // 
                case 0:
                {
                    System.out.println("Введите имя гафа.");
                    String gName = in.nextLine();
                    graphBase.add(OGraph(gName));
                    break;
                }
                // 
                case 1:
                {
                    System.out.println("Введите имя гафа.");
                    String gName = in.nextLine();
                    graphBase.add(NOGraph(gName));
                    break;
                }
                //
                case 2:
                {
                    System.out.println("Введите имя гафа.");
                    String gName = in.nextLine();
                    graphBase.add(MGraph(gName));
                    break;
                }
                // 
                case 3:
                {
                    System.out.println("Введите имя файла из которого будете считывать данные.");
                    String fName = in.nextLine();

                    FileReader fr = new FileReader(fName);

                    fr.close();
                    break;
                }
                //
                case 4:
                {
                    System.out.println("");
                    String fName = in.nextLine();

                    FileWriter fw = new FileWriter(fName);

                    fw.close();
                    break;
                }
                //
                case 5:
                {
                    break;
                }
                //
                case 6:
                {
                    while (!eFlag2)
                    {
                        System.out.println("Введите что будете делать:");
                        System.out.println("1 - Добавить вершину.");
                        System.out.println("2 - Добавить ребро.");
                        System.out.println("3 - Удалить ершину.");
                        System.out.println("4 - Удалить ребро.");
                        System.out.println("5 - Очистить список смежности.");
                        System.out.println("6 - Выйти из редактирования графа.");

                        action2 = in.nextInt() - 1;

                        switch(action2)
                        {
                            //
                            case 0:
                            {}
                            //
                            case 1:
                            {}
                            //
                            case 2:
                            {}
                            //
                            case 3:
                            {}
                            //
                            case 4:
                            {}
                            //
                            case 5:
                            {}
                            //
                            default:
                            {}
                        }
                    }
                    break;
                }
                //
                case 7:
                {
                    break;
                }
                //
                case 8:
                {
                    break;
                }
                //
                case 9:
                {
                    break;
                }
                //
                default:
                {
                    break;
                }
            }
        }
        in.close();
    }
}
