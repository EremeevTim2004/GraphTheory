import java.util.*;
import java.io.*;

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
            System.out.println("8 - Вывести информацию о всех графах.");
            System.out.println("9 - Отформатировать базу.");
            System.out.println("10 - Выйти из программы.");

            action1 = in.nextInt() - 1;

            switch(action1)
            {
                // Создание пустого ориентированного графа
                case 0:
                {
                    System.out.println("Введите имя гафа.");
                    String gName = in.nextLine();

                    for (int i = 0; i < graphBase.size(); i ++)
                    {
                        if (graphBase.get(i).graphName == gName)
                        {
                            System.out.println("Граф с таким именем уже есть.");
                            break;
                        } else System.out.println("Такое имя свободно.");
                    }

                    OGraph oGraph = new OGraph(gName);
                    graphBase.add(oGraph);

                    break;
                } // Создание пустого неориентированного графа
                case 1:
                {
                    System.out.println("Введите имя гафа.");
                    String gName = in.nextLine();

                    for (int i = 0; i < graphBase.size(); i ++)
                    {
                        if (graphBase.get(i).graphName == gName)
                        {
                            System.out.println("Граф с таким именем уже есть.");
                            break;
                        } else System.out.println("Такое имя свободно.");
                    }

                    NOGraph noGraph = new NOGraph(gName);
                    graphBase.add(noGraph);

                    break;
                } // Создание пустого смешанного графа
                case 2:
                {
                    System.out.println("Введите имя гафа.");
                    String gName = in.nextLine();

                    for (int i = 0; i < graphBase.size(); i ++)
                    {
                        if (graphBase.get(i).graphName == gName)
                        {
                            System.out.println("Граф с таким именем уже есть.");
                            break;
                        } else System.out.println("Такое имя свободно.");
                    }

                    MGraph mGraph = new MGraph(gName);
                    graphBase.add(mGraph);

                    break;
                } // Создать новый граф-копию i-го графа
                case 3:
                {
                    for (int i = 0; i < graphBase.size(); i ++) System.out.println(graphBase.get(i).graphName);
                    
                    System.out.println("Выбирите граф для копирования.");
                    int gNum = in.nextInt();

                    if (graphBase.get(gNum).getClass().getName() == "OGraph") 
                    {
                        OGraph oGraphCopy = OGraph(graphBase.get(gNum)); 
                        graphBase.add(oGraphCopy);
                        graphBase.get(gNum).graphName += " Copy";
                    } else if (graphBase.get(gNum).getClass().getName() == "NOGraph")
                    {
                        NOGraph nOGraphCopy = NOGraph(graphBase.get(gNum)); 
                        graphBase.add(nOGraphCopy);
                        graphBase.get(gNum).graphName += " Copy";
                    } else if (graphBase.get(gNum).getClass().getName() == "MGraph") 
                    {
                        MGraph mGraphCopy = MGraph(graphBase.get(gNum)); 
                        graphBase.add(mGraphCopy);
                        graphBase.get(gNum).graphName += " Copy";
                    }

                    break;
                } // Создать новый граф на основе файла-конфигуратора
                case 4:
                {
                    System.out.println("Введите имя файла, из которого будете считывать данные.");
                    String fName = in.nextLine();

                    FileReader fr = new FileReader(fName);

                    fr.close();
                    break;
                } // Создать файл-конфигуратор на основе i-го графа
                case 5:
                {
                    System.out.println("Введите имя файла, в который будут заностится данные.");
                    String fName = in.nextLine();

                    FileWriter fw = new FileWriter(fName);

                    fw.close();
                    break;
                } // Настройка i-го графа
                case 6:
                {
                    for (int i = 0; i < graphBase.size(); i ++) System.out.println(graphBase.get(i).graphName);
                    
                    System.out.println("Выбирите граф для дальнейших преобразований.");
                    int gNum = in.nextInt();
                    String gType = graphBase.get(gNum).getClass().getName();

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
                            // Добавить вершину
                            case 0:
                            {
                                if (gType == "OGraph")
                                {} else if (gType == "NOGraph")
                                {} else if (gType == "MGraph")
                                {}

                                break;
                            } // Добавить ребро
                            case 1:
                            {
                                if (gType == "OGraph")
                                {} else if (gType == "NOGraph")
                                {} else if (gType == "MGraph")
                                {}

                                break;
                            } // Удалить вершину
                            case 2:
                            {
                                if (gType == "OGraph")
                                {} else if (gType == "NOGraph")
                                {} else if (gType == "MGraph")
                                {}

                                break;
                            } // Удалить ребро
                            case 3:
                            {
                                if (gType == "OGraph")
                                {} else if (gType == "NOGraph")
                                {} else if (gType == "MGraph")
                                {}

                                break;
                            } // Очистить список смежности
                            case 4:
                            {
                                if (gType == "OGraph")
                                {} else if (gType == "NOGraph")
                                {} else if (gType == "MGraph")
                                {}

                                break;
                            } // Выход из режима редактирования графа
                            case 5:
                            {
                                eFlag2 = true;
                                break;
                            } default:
                            {
                                System.out.println("Нет такой опции!");
                                break;
                            }
                        }
                    }
                    break;
                } // Вывести информацию о базе
                case 7:
                {
                    for (int i = 0; i < graphBase.size(); i ++)
                    {
                        System.out.println(graphBase.get(i).graphName + " ");
                        System.out.print(graphBase.get(i).topNum + " ");
                        System.out.print(graphBase.get(i).edgeNum + " ");
                        for (int j = 0; j < graphBase.get(i).adjacencyList.size(); j ++)
                        {
                            for (int k = 0; k < graphBase.get(i).adjacencyList.size(); k ++)
                            {
                                System.out.println(graphBase.get(i).adjacencyList.get(j).get(k));
                            }
                        }
                        System.out.println(".");
                    }
                    break;
                } // Очистка базы
                case 8:
                {
                    graphBase.removeAll(graphBase);
                    System.out.println("База успешно отформатированна.");
                    break;
                } // Выход из программы
                case 9:
                {
                    eFlag1 = true;
                    break;
                } default:
                {
                    System.out.println("Нет такой опции!");
                    break;
                }
            }
        }
        in.close();
    }
}
