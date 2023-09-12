#include <iostream>
#include <vector>
#include <fstream>
#include <string>

using namespace std;

// Структура данных для хранения ребра Graph
struct Edge
{
    int src; 
    int dest;
};
/*
// Список графов
class GraphList()
{}
*/
// Класс Граф
class Graph
{
	public:
		// Название графа для удобства польщователя
		string GraphName;
		// Вектор векторов для представления списков смежности
		vector<vector<int>> AdjacencyList;

		// Конструктор, создающий пустой граф
		Graph(string gName)
		{}
		// Конструктор, заполняющий данные графа из файла
		Graph(string fName, string gName, vector<Edge> const &edges)
		{}
		// Конструктор копирования
		Graph(const Graph &g)
		{}

		void AddTop()
		{}
		void AddEdge()
		{}
		void RemoveTop()
		{}
		void RemoveEdge()
		{}
		void AdjacencyListPrint()
		{}
};

int main()
{
	int action1 = 0;
	int action2 = 0;
	bool flag1 = false;
	bool flag2 = false;

	while(!flag1)
	{
		std::cout << "Input action:" << std::endl;
		std::cout << "1 - Generate empty graph." << std::endl;
		std::cout << "2 - Generate graph from file." << std::endl;
		std::cout << "3 - Choose graph for work." << std::endl;
		std::cout << "4 - Exit." << std::endl << ">>";
		std::cin >> action1;
		switch(action1)
		{
			case 1:
			{
				string gName = "";
				std::cout << "Input name for new graph." << std::endl << ">>";
				std::cin >> gName;
				// Проверка имени на оригинальность
				// Герерация графа + присвоение имени, придуманне пользователем
				// Добавление нового графа в базу
				break;
			} case 2:
			{
				string fName = "";
				std::cout << "" << std::endl << ">>";
				std::cin >> fName;
				// Проверка файла на существование и открытие
				// Ввод имени файла, откуда будут браться данные
				string gName = "";
				std::cout << "Input name for new graph." << std::endl << ">>";
				std::cin >> gName;
				// Проверка имени на оригинальность
				// Генерация графа с присвоением данных из файла
				// Закрытие файла
				// Присвоение имени, придуманне пользователем
				// Добавление в базу 
				break;
			} case 3:
			{
				// Выводится список всех графов всех имеющихся графов, записанных в базу
				// Пользователь выбирает с каким именно хочет работать
				while(!flag2)
				{
					std::cout << "Input action for graph:" /*<< graphList[i].GraphName*/<< std::endl;
					std::cout << "1 - Add top." << std::endl;
					std::cout << "2 - Add edge." << std::endl;
					std::cout << "3 - Remove top." << std::endl;
					std::cout << "4 - Remove edge." << std::endl;
					std::cout << "5 - Print adjacency list." << std::endl;
					std::cout << "6 - Copy graph to file." << std::endl;
					std::cout << "7 - Exit." << std::endl << ">>";
					std::cin >> action2;
					switch(action2)
					{
						case 1:
						{
							// Добавление вершины
							// Правим список смежности
							break;
						} case 2:
						{
							bool chooser;
							std::cout << "Ориентированное(1) или неориентированное(0)?" << std::endl << ">>";
							std::cin >> chooser;
							if (chooser)
							{
								// Проверка на возможность добавления ребра (количество вершин > 1)
								// Проверка ориентированности ребра, 
								// если между двумя выбранными вершинами ребро уже есть
								// Правим список смежности
							} else
							{
								// Проверка на возможность добавления ребра (количество вершин > 1)
								// Проверка на наличие ребра между двумя выбранными вершинами
								// Правим список смежности
							}						
							break;
						} case 3:
						{
							// Пользователь выбирает какую вершину удалить,
							// если такая вершина есть, то удаляем
							// Правим список смежности
							break; 
						} case 4:
						{
							// Пользователь выбирает какое ребро удалить,
							// если ребро ориентированное, то спрашиваем:
							// удалить только ориентированность в одну из сторон
							// или удалить ребро полностью
							// Правим список смежности
							break;
						} case 5:
						{
							// Печать списка смежности
							break;
						} case 6:
						{
							// Пользователь вводит название файла, 
							// в который он хочет скопировать данные о графе
							// Копирование данных в файл
							break;
						} case 7:
						{
							flag2 = true;
							break;
						} default:
						{
							std::cout << "No such action!" << std::endl;
							std::cout << "Try again!" << std::endl;
							break;
						}
					}
				}
				break;
			} case 4:
			{
				flag1 = true;
				break;
			} default:
			{
				std::cout << "No such action!" << std::endl;
				std::cout << "Try again!" << std::endl;
				break;
			}
		}
	}
	return 0;
}