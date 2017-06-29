Trabalho - Automovel Completo com Arquivos.cpp
DETALHES
ATIVIDADE
No ano passado

O utilizador criou um item em
29/06/2016
Pasta do Google Drive
Programação 1
Text
Trabalho - Automovel Completo com Arquivos.cpp
Nenhuma atividade registada antes de 29 de junho de 2016


#include <stdio.h>
#include <string.h>
#include <conio.h>
#include <dos.h>
#include <stdlib.h>
#include <windows.h>
#include <time.h>
#include <ctype.h>
#include <locale.h>

void cores(int ForgC, int BackC){
     WORD wColor = ((BackC & 0x0F) << 4) + (ForgC & 0x0F);;
     SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), wColor);
     return;
}

void textcolor(int newcolor){
   CONSOLE_SCREEN_BUFFER_INFO csbi;
   GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi);
   SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),
     (csbi.wAttributes & 0xf0) | newcolor);
}

void gotoxy(int x, int y) {
  COORD c;
  c.X = x - 1;
  c.Y = y - 1;
  SetConsoleCursorPosition (GetStdHandle(STD_OUTPUT_HANDLE), c);
}


void cadastro_automovel();
void cadastro_clientes();
void alterar_automovel();
void locar_automovel();
void retornar_carro();
void listar_auto();
void listar_locados();
void listar_livres();
void consultar_situacao();

struct automovel
{
 char placa[7];
 int ano_fabricacao;
 int numero_lugares;
 char situacao[10];
}carro;

struct cliente
{
 int codigo_cliente;
 char nome_cliente[30];
 int numero_carteira_motorista;
}pessoa;

struct locados
{
 char placa_locado[7];
 int codigo_cliente_locador;
 char data_locacao[10];
 char data_devolucao[10];
}locacao;


 int cont = 0;

 main()
{
 	system("cls");
	setlocale(LC_ALL, "Portuguese");

 int menu;

 gotoxy(27,1);
 printf("MENU PRINCIPAL\n");
 printf("1 - CADASTRAR UM AUTOMOVEL");
 printf("\n\n2 - CADASTRAR UM CLIENTE");
 printf("\n\n3 - ALTERAR SITUAÇÃO DO AUTOMÓVEL");
 printf("\n\n4 - LOCAR UM AUTOMÓVEL");
 printf("\n\n5 - RETORNAR UM AUTOMÓVEL LOCADO");
 printf("\n\n6 - LISTAR AUTOMÓVEIS");
 printf("\n\n7 - LISTAR AUTOMÓVEIS LIVRES");
 printf("\n\n8 - LISTAR AUTOMÓVEIS LOCADOS");
 printf("\n\n9 - CONSULTAR SITUAÇÃO DE UM CARRO");
 printf("\n\n10 - SAIR DO PROGRAMA");
 printf("\n\nDIGITE A SUA OPCAO: ");
 scanf("%d",&menu);
 switch (menu)
 {case 1:
 	cadastro_automovel();
 	break;
 case 2:
 	cadastro_clientes();
 	break;
 case 3:
 	alterar_automovel();
 	break;
 case 4:
 	locar_automovel();
 	break;
 case 5:
 	retornar_carro();
 	break;
 case 6:
 	listar_auto();
 	break;
 case 7:
 	listar_livres();
 	break;
 case 8:
 	listar_locados();
 	break;
 case 9:
 	consultar_situacao();
 	break;
 case 10:
 	system("cls");
		gotoxy(27,1);
			printf("Obrigado por usar nosso software de gestao!");
		gotoxy(27,2);
			printf("SHIGOTO IND. SOFT.");
			exit(0);
	break;

 default: system("cls");
 	printf("FUNÇÃO INVALIDA, TENTE NOVAMENTE!!");
 getch();
 main();
 }

  getch(); // força uma parada do programa no final da seua execução.
}

void cadastro_automovel()
{
	system("cls");
	FILE *cars;
	cars = fopen("AUTOMOVEL.txt","a+");
    if (cars == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
    char aux3[10];
    int ler;
    fflush(stdin);
	printf("Digite a placa do automovel: ");
    gets(aux3);
	ler = fread(&carro,sizeof(struct automovel),1,cars);
	while(ler == 1)
    {
    	if(stricmp(aux3, carro.placa) == 0)
    	{
    		printf("Esta placa já está cadastrada.\nprecione qualquer botão para voltar para o menu.");
    		getch();
    		fclose(cars);
    		main();
    	}
		ler = fread(&carro,sizeof(struct automovel),1,cars);
    }
    strcpy(carro.placa, aux3);
    strupr(carro.placa);
	printf("Digite o ano de fabricacão do veículo: ");
	scanf("%d",&carro.ano_fabricacao);
	do
	{
		printf("Digite o numero de lugares do veículo: ");
		scanf("%d",&carro.numero_lugares);
	}
	while(carro.numero_lugares < 2 || carro.numero_lugares > 10);

	strcpy(carro.situacao, "Livre");

	fwrite(&carro,sizeof(struct automovel),1,cars);
	fclose(cars);
	main();
}

void cadastro_clientes()
{
	system("cls");
	FILE *pessoas;
	pessoas = fopen("CLIENTES.txt","a+");
    if (pessoas == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
    fflush(stdin);
	printf("Digite o nome do cliente: ");
	gets(pessoa.nome_cliente);
	strupr(pessoa.nome_cliente);
	  
    int ler, aux;  
	printf("Digite o codigo do cliente: ");
	scanf("%d",&aux);
	ler = fread(&pessoa,sizeof(struct cliente),1,pessoas);
	while(ler == 1)
    {
    	if(aux == pessoa.codigo_cliente)
    	{
    		printf("Esta usuário ja esá cadastrado.\nprecione qualquer botão para voltar para o menu.");
    		fclose(pessoas);
			getch();
    		main();
    	}
		ler = fread(&pessoa,sizeof(struct cliente),1,pessoas);
    }
    pessoa.codigo_cliente = aux;

	do{
	printf("Digite o numero da carteira da motorista: ");
	scanf("%d",&pessoa.numero_carteira_motorista);
	} while(pessoa.numero_carteira_motorista == 11 );

	fwrite(&pessoa,sizeof(struct cliente),1,pessoas);
	fclose(pessoas);
	main();
}

void alterar_automovel()
{
	system("cls");
	FILE *cars;
	cars = fopen("AUTOMOVEL.txt","rw+");
    if (cars == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
    char aux[10];
    fflush(stdin);
	printf("Digite a placa do automovel: ");
    gets(aux);
    fseek(cars, 0L, SEEK_SET);
	int ler, posicao = 0;
	ler = fread(&carro,sizeof(struct automovel),1,cars);
	while(ler == 1)
    {
    	if(stricmp(aux, carro.placa) == 0)
    	{
				system("cls");
				int aux2;
    			printf("Para qual alteração voce deseja alterar?\n");
    			printf("1 - DE LIVRE PARA MANUTENÇÃO\n");
    			printf("2 - DE MANUTENÇÃO PARA LIVRE\n");
    			printf("3 - DE LIVRE OU MANUTENÇÃO PARA VENDIDO\n");
    			printf("Digite aqui: ");
				scanf("%d",&aux2);
				switch (aux2)
				{
				case 1:
					system("cls");
				    fseek(cars, 0L, SEEK_SET);
                    fseek(cars, posicao*sizeof(automovel), SEEK_SET);
                    strcpy(carro.situacao , "Manutencao");
					fwrite(&carro,sizeof(struct automovel),1,cars);
					fclose(cars);
            	break;

                case 2:
                	system("cls");
                    fseek(cars, 0L, SEEK_SET);
                    fseek(cars, posicao*sizeof(automovel), SEEK_SET);
                    strcpy(carro.situacao , "Livre");
					fwrite(&carro,sizeof(struct automovel),1,cars);
					fclose(cars);
                break;

                case 3:
                	system("cls");
                    fseek(cars, 0L, SEEK_SET);
                    fseek(cars, posicao*sizeof(automovel), SEEK_SET);
                    strcpy(carro.situacao , "vendido");
                    fwrite(&carro,sizeof(struct automovel),1,cars);
					fclose(cars);
                break;

                default:system("cls"); printf("Numero invalido, digite novamente.\n\n");
    			}
    	}
    	posicao++;
		ler = fread(&carro,sizeof(struct automovel),1,cars);
	}
	main();
}

void locar_automovel()
{
	system("cls");
	FILE *locar;
	locar = fopen("LOCADOS.txt","a+");
    if (locar == NULL)
      {
         system("cls");
		 textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
	// PEGANDO DADOS DO VEICULO
	system("cls");
	FILE *cars;
	cars = fopen("AUTOMOVEL.txt","r+");
    if (cars == NULL)
      {
         system("cls");
		 textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
    char aux[10]; 
    fflush(stdin);  
    printf("Digite a placa do carro: ");
    gets(aux);
	fseek(cars, 0L, SEEK_SET);
	int ler, posicao = 0;
	int achou= 0 ;
	ler = fread(&carro,sizeof(struct automovel),1,cars);
	while(ler == 1 )
		{
			if(stricmp(aux, carro.placa) == 0 && stricmp(carro.situacao, "livre") == 0)
			{
				system("cls");
				printf("Placa do carro: %s\n", carro.placa);
				strcpy(locacao.placa_locado, carro.placa);
    			printf("Ano do carro: %d\n", carro.ano_fabricacao);
    			printf("Numero de lugares do carro: %d\n", carro.numero_lugares);
    			printf("Situação do carro: %s",carro.situacao);
				fseek(cars, 0L, SEEK_SET);
                fseek(cars, posicao*sizeof(automovel), SEEK_SET);
                strcpy(carro.situacao , "Locado");
                fwrite(&carro,sizeof(struct automovel),1,cars);
                getch();
    			achou = 1;
    			fclose(cars);
			}	
		posicao++;
		ler = fread(&carro,sizeof(struct automovel),1,cars);
		}
	if(achou == 0)
	{
		printf("Este Veiculo Não está disponivel para locação!");
		getch();
		fclose(cars);
		fclose(locar);
		main();	
	}
	system("cls");
	getch();

	system("cls");
	FILE *pessoas;
	pessoas = fopen("CLIENTES.txt","rb");
    if (pessoas == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
	int aux2;  
    printf("Digite o codigo do cliente: ");
    scanf("%d",&aux2);
    system("cls");
	fseek(pessoas, 0L, SEEK_SET);
	int ler2, posicao2 = 0;
	ler2 = fread(&pessoa,sizeof(struct cliente),1,pessoas);
	while(ler2 == 1 )
		{
			if(aux2 == pessoa.codigo_cliente)
			{
				system("cls");
				fflush(stdin);
				printf("Digite a data locacao: ");
				gets(locacao.data_devolucao);
				printf("Codigo do cliente: %d\n", pessoa.codigo_cliente);
				locacao.codigo_cliente_locador = pessoa.codigo_cliente;
    			printf("Nome do Cliente: %s\n", pessoa.nome_cliente);
    			printf("Numero da carteira de motorista: %d\n", pessoa.numero_carteira_motorista);
				getch();
				fwrite(&locacao,sizeof(struct locados),1,locar);
			}	
		posicao2++;
		ler2 = fread(&pessoa,sizeof(struct cliente),1,pessoas);
		}
		getch();
    	system("cls");  
 		fclose(pessoas);
		fclose(locar);
    	main();    
}

void retornar_carro()
{
	system("cls");
	FILE *cars;
	cars = fopen("AUTOMOVEL.txt","rw+");
    if (cars == NULL)
    {
         system("cls");
		 textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
    }
    char aux[10]; 
    fflush(stdin);  
    printf("Digite a placa do carro: ");
	gets(aux);
     
	fseek(cars, 0L, SEEK_SET);
	int ler2, posicao2 = 0;
	int achou2= 0 ;
	ler2 = fread(&carro,sizeof(struct automovel),1,cars);
	while(ler2 == 1 )
		{
			if(stricmp(aux, carro.placa) == 0 && stricmp(carro.situacao, "locado") == 0)
			{
				system("cls");
				fseek(cars, 0L, SEEK_SET);
                fseek(cars, posicao2*sizeof(automovel), SEEK_SET);
                strcpy(carro.situacao , "Livre");
                fwrite(&carro,sizeof(struct automovel),1,cars);
                getch();
    			achou2 = 1;
    			fclose(cars);
			}	
		posicao2++;
		ler2 = fread(&carro,sizeof(struct automovel),1,cars);
		}
		if(achou2 == 0)
		{
			printf("Este Veiculo não esta locado!");
			getch();
			fclose(cars);
			main();	
		}
	system("cls");
	FILE *locar;
	locar = fopen("LOCADOS.txt","a+");
    	if (locar == NULL)
			{
         		system("cls");
         		printf("Entrei\n");
		 		textcolor(4);
        	 	printf("\nErro na abertura do arquivo !!");
         		getch();
        	 	system("cls");
         		textcolor(15);
         		main();
    		}	
	fseek(locar, 0L, SEEK_SET);
    int ler, posicao = 0;
    int achou = 0;
    ler = fread(&locacao,sizeof(struct locados),1,locar);
    	while(ler == 1)
    		{
					if(stricmp(locacao.placa_locado, aux) == 0)
						{
							fseek(locar, 0L, SEEK_SET);
            				fseek(locar, posicao*sizeof(locados), SEEK_SET);
            				fflush(stdin);
							printf("Digite a data de devolucao do veiculo: ");
							gets(locacao.data_devolucao);
							achou = 1;
							fwrite(&locacao,sizeof(struct locados),1,locar);
							fclose(locar);	
						}
				posicao++;
				printf("Posicao = %d\n",posicao);
				ler = fread(&locacao,sizeof(struct locados),1,locar);
    			printf("LER = %d\n",ler);
			}	
		if(achou == 0)
			{
				printf("Nao existem carros locados!!");
				fclose(locar);
    			fclose(cars);
				getch();
				main();
			}		
	system("cls");
	getch();
	main();
}

void listar_auto()
{
	system("cls");
	FILE *cars;
		cars = fopen("AUTOMOVEL.txt","r+");
    if (cars == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
      int ler;
      ler = fread(&carro,sizeof(struct automovel),1,cars);
      while(ler == 1)
    	{
    		printf("Placa do Veiculo: %s", carro.placa);
      		printf("\nAno de Fabricação do Veiculo: %d", carro.ano_fabricacao);
      		printf("\nNúmero de Lugares: %d", carro.numero_lugares);
      		printf("\nSituação do Veiculo: %s",carro.situacao);
      		printf ("\n===========================================\n");
			ler = fread(&carro,sizeof(struct automovel),1,cars);
    	}
    getch();
    fclose(cars);
	main();
	
}

void listar_locados()
{
	system("cls");
	FILE *cars;
		cars = fopen("AUTOMOVEL.txt","r");
    if (cars == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
	system("cls");
	FILE *locar;
		locar = fopen("LOCADOS.txt","r+");
    if (locar == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
      int ler, achou = 0;
      ler = fread(&locacao,sizeof(struct locados),1,locar);
      while(ler == 1 && stricmp(carro.situacao , "locado"))
    	{		
    		printf("Nome do locatario: %s",pessoa.nome_cliente);
      		printf("\nData da locacao: %s", locacao.data_locacao);
      		printf ("\n===========================================\n");
			ler = fread(&locacao,sizeof(struct locados),1,locar);
			achou = 1;
    	}
	if(achou == 0)
	{
			printf("Nao existem carros locados!!");
			fclose(locar);
    		fclose(cars);
			getch();
			main();
	}		
    getch();
    fclose(locar);
    fclose(cars);
	main();	
}

void listar_livres()
{
	system("cls");
	FILE *cars;
		cars = fopen("AUTOMOVEL.txt","r");
    if (cars == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
      int ler;
      ler = fread(&carro,sizeof(struct automovel),1,cars);
      while(ler == 1)
    	{
    		if(stricmp(carro.situacao, "Livre") == 0)
    		{
    			printf("Placa do Veiculo: %s", carro.placa);
      			printf("\nAno de Fabricação do Veiculo: %d", carro.ano_fabricacao);
      			printf("\nNúmero de Lugares: %d", carro.numero_lugares);
      			printf("\nSituação do Veiculo: %s",carro.situacao);
      			printf ("\n===========================================\n");
			}
			ler = fread(&carro,sizeof(struct automovel),1,cars);
    	}
    getch();
    fclose(cars);
	main();	
}

void consultar_situacao()
{
	system("cls");
	FILE *cars;
		cars = fopen("AUTOMOVEL.txt","r");
    if (cars == NULL)
      {
         system("cls");
         textcolor(4);
         printf("\nErro na abertura do arquivo !!");
         getch();
         system("cls");
         textcolor(15);
         main();
      }
      char aux[7];
      int posicao =0;
      fflush(stdin);
	  printf("Digite a Placa do veiculo para consulta: ");
      gets(aux);
	  int ler;
      ler = fread(&carro,sizeof(struct automovel),1,cars);
      while(ler == 1)
    	{
    		if(stricmp(aux, carro.placa) == 0)
    		{
    			printf("Placa do Veiculo: %s", carro.placa);
      			printf("\nAno de Fabricação do Veiculo: %d", carro.ano_fabricacao);
      			printf("\nNúmero de Lugares: %d", carro.numero_lugares);
      			printf("\nSituação do Veiculo: %s",carro.situacao);
			}
			ler = fread(&carro,sizeof(struct automovel),1,cars);
    	}
    getch();
    fclose(cars);
	main();	
}