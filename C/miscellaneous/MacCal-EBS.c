/*
	This program aim to simplify the mac cal for ebs install in culster.conf file.

	example:


	#Define node interface
	#Base MAC Address of SC-1(slot 9): 34:07:fb:35:0e:7d
	interface 1 eth3 ethernet 34:07:fb:35:0e:7e
	interface 1 eth4 ethernet 34:07:fb:35:0e:7f
	interface 1 eth5 ethernet 34:07:fb:35:0e:85
	interface 1 eth6 ethernet 34:07:fb:35:0e:86

	#Base MAC address of SC-2(slot 11): 34:07:fb:35:0e:73
	interface 2 eth3 ethernet 34:07:fb:35:0e:74
	interface 2 eth4 ethernet 34:07:fb:35:0e:75
	interface 2 eth5 ethernet 34:07:fb:35:0e:7b
	interface 2 eth6 ethernet 34:07:fb:35:0e:7c


	by Leo 2013-05-27
*/
#include <stdio.h>
#include <string.h>

void StrTrip(char* src);
int Char2int(char src);
char* Mac_add(char* Mac_str, int delta);
char Int2char(int src);
int CheckMac(char* mac_add);
void PrintMac(char* mac_str);

#define MAXLENGTH 255
#define MAXMAC 15

struct Mac_Info
{
	char Mac_addr[MAXLENGTH];
	char interface[MAXLENGTH];
};

int main()
{
	char Mac[MAXLENGTH]; //= " ff:ff:ff:ff:ff:fa  ";
	char interface[MAXLENGTH];
	char answer; //[MAXLENGTH];
	struct Mac_Info mac_info[MAXMAC];
	int index = 0;
	int check_result;

	while(1){
		printf("Please input the first mac address(xx:xx:xx:xx:xx:xx): ");
		//scanf("%s", Mac);
		scanf("%s", mac_info[index].Mac_addr);
		StrTrip(mac_info[index].Mac_addr);
		check_result = CheckMac(mac_info[index].Mac_addr);

		if(check_result == -1){
			printf("mac address string length wrong, please check!\n");
			return -1;
		}
		else if(check_result == -2){
			printf("mac address contain bad character, please check!\n");
			return -2;
		}
		else if(check_result == -3){
			printf("mac address use colon : as the delimeter, please check!\n");
			return -3;
		}
		//printf("interface: %d\tMac_addr: %s\n", index, mac_info[index].Mac_addr);	

		printf("Please input the interface(1, 2, 3, 4): ");
		//scanf("%s", interface);
		scanf("%s", mac_info[index].interface);
		//printf("interface: %d\tinterface: %s\n", index, mac_info[index].interface);	

		printf("Continue? (Y/N)");

		getchar();
		//getchar();
		//scanf("%s", answer);
		answer = getchar();
		if(answer == 'Y' || answer == 'y'){
			printf("you choose %c\n", answer);
		}
		else if(answer == 'N' || answer == 'n'){
			printf("you choose %c\n", answer);
			//return -7;
			break;
		}
		else {
			printf("Bad choose!\n");
			return -2;
			//printf("Continue? (Y/N)");
			//getchar();
			//answer = getchar();
		}

		index++;
		if(index > MAXMAC - 1){
			printf("Too much interface(<16)!\n");
			return -3;
		}
	}
	
	//printf("Out of while(1)\n!");
	//getchar();
	//printf("Please input the first mac address(xx:xx:xx:xx:xx:xx): ");
	//char Mac[MAXLENGTH]; //= " ff:ff:ff:ff:ff:fa  ";
	//scanf("%s", Mac);
	//char interface[MAXLENGTH];
	//printf("Please input the interface(1, 2, 3, 4): ");
	//scanf("%s", interface);
	//printf("%s\n", Mac);
	//printf("\n");
	//int check_result;
	//StrTrip(Mac);
	//printf("%s\n", Mac);
	//check_result = CheckMac(Mac);
	//printf("%d\n", check_result);
	//printf("%s\n", Mac);

	int i = 0;
	//int j = 0;
	//char *token;
	//char Mac_str[13];
	//Mac_str[12] = '\0';
	//char* result;
	//char *temp = Mac_str;

	for(i = 0; i <= index; i++){

		char *token;
		char Mac_str[13];
		Mac_str[12] = '\0';
		char* result;
		int j = 0;
		//char *token;
		//char Mac_str[13];
		//Mac_str[12] = '\0';
		printf("# interface: %s\t firstMacAddress: %s\n", mac_info[i].interface, mac_info[i].Mac_addr);
		token = strtok(mac_info[i].Mac_addr, ":");
		//int i = 0;
		while (token != NULL){
		//strcat(Mac_str, token);
		//printf("%c\n", token[0]);
			Mac_str[j] = token[0];
			Mac_str[j+1] = token[1];
			j = j + 2;
			token = strtok(NULL, ":");
		}
		//char* result;
		//char *temp = Mac_str;
		//printf("# interface: %s\t firstMacAddress: %s\n", mac_info[i].interface, mac_info[i].Mac_addr);
		result = Mac_add(Mac_str, 1);
		printf("interface %s eth3 ethernet ", mac_info[i].interface);
		PrintMac(result);
		printf("\t # firstmacaddress + 1\n");
		//printf("%s\n", result);
		//unsigned long long int Mac_int = strtoull(Mac_str, NULL, 16);
		//printf("%d\n", Mac_int);

		//temp = Mac_str;
		result = Mac_add(Mac_str, 2);
		printf("interface %s eth4 ethernet ", mac_info[i].interface);
		PrintMac(result);
		printf("\t # firstmacaddress + 2\n");

		result = Mac_add(Mac_str, 8);
		printf("interface %s eth5 ethernet ", mac_info[i].interface);
		
/*
	separate the mac address 
*/
		PrintMac(result);
		printf("\t # firstmacaddress + 8\n");


		result = Mac_add(Mac_str, 9);
		printf("interface %s eth6 ethernet ", mac_info[i].interface);
		PrintMac(result);
		printf("\t # firstmacaddress + 9\n");
	}
	//printf("%s\n", Mac_str);


	//int test = 0;
	//printf("%c\n", Mac_str[6]);
	//test = Char2int(Mac_str[6]);
	//printf("%d\n", test);



	return 0;

}

void StrTrip(char* src)
{
	char* p = src;
	char* q = src;
	while(*q++); q -= 2;
	while(p<=q && isspace(*q)) q--;
	while(p<=q && isspace(*p)) p++;
	while (p<=q) *src++ = *p++;
	*src = '\0';
//	return src;
}


int Char2int(char src){
	char temp = src;
	if(temp >= '0' && temp <= '9'){
		return temp - '0';
	}
	if(temp >= 'a' && temp <= 'f'){
		return temp - 'a' + 10;
	}
	if(temp >= 'A' && temp <= 'F'){
		return temp - 'A' + 10;
	}
}

char Int2char(int src){
	int temp = src;
	if(temp >= 0 && temp <= 9){
		return temp - 0 + '0';
	}
	if(temp >= 10 && temp <= 15){
		return temp - 10 + 'a';
	}
}

char* Mac_add(char* Mac_str, int delta){
	/* Mac_str is the input Mac_address string
	   Length is 12
	*/
	static char temp[13];
	//char *temp = Mac_str;
	strcpy(temp, Mac_str);
	int i = 0;
	//while(Mac_str[i] != '\0'){
		//temp[i] = Mac_str[i];
		//i++;
	//}
	//temp[12] = '\0';
	//printf("%s\n", temp);
	int last_int = Char2int(temp[11]);
	int Mac_int[12];
	for (i = 0; i < 12; i++){
		Mac_int[i] = Char2int(temp[i]);
	}
	last_int += delta;
	if(last_int < 16){
		temp[11] = Int2char(last_int);
	}
	else{
		temp[11] = Int2char(last_int - 16);
		Mac_int[10] += 1;
		if (Mac_int[10] < 16){
			temp[10] = Int2char(Mac_int[10]);
		}
		else{
			temp[10] = Int2char(Mac_int[10] - 16);
			Mac_int[9] += 1;
			if (Mac_int[9] < 16){
				temp[9] = Int2char(Mac_int[9]);
			}
			else{
				temp[9] = Int2char(Mac_int[9] - 16);
				Mac_int[8] += 1;
				if (Mac_int[8] < 16){
					temp[8] = Int2char(Mac_int[8]);
				}
				else{
					temp[8] = Int2char(Mac_int[8] - 16);
					Mac_int[7] += 1;
				
					if (Mac_int[7] < 16){
						temp[7] = Int2char(Mac_int[7]);
					}
					else{
						temp[7] = Int2char(Mac_int[7] - 16);
						Mac_int[6] += 1;
						
						if (Mac_int[6] < 16){
							temp[6] = Int2char(Mac_int[6]);
						}
						else{
							temp[6] = Int2char(Mac_int[6] - 16);
							Mac_int[5] += 1;
						
							if (Mac_int[5] < 16){
								temp[5] = Int2char(Mac_int[5]);
							}
							else{
								temp[5] = Int2char(Mac_int[5] - 16);
								Mac_int[4] += 1;
							
								if (Mac_int[4] < 16){
									temp[4] = Int2char(Mac_int[4]);
								}
								else{
									temp[4] = Int2char(Mac_int[4] - 16);
									Mac_int[3] += 1;
								
									if (Mac_int[3] < 16){
									temp[3] = Int2char(Mac_int[3]);
								}
								else{
									temp[3] = Int2char(Mac_int[3] - 16);
									Mac_int[2] += 1;
									
										if (Mac_int[2] < 16){
										temp[2] = Int2char(Mac_int[2]);
										}
										else{
											temp[2] = Int2char(Mac_int[2] - 16);
											Mac_int[1] += 1;
											
											if (Mac_int[1] < 16){
												temp[1] = Int2char(Mac_int[1]);
											}
											else{
												temp[1] = Int2char(Mac_int[1] - 16);
												Mac_int[0] += 1;
												if (Mac_int[0] < 16){
												temp[0] = Int2char(Mac_int[0]);
												}
												else{
													//printf("ERROR!!!\n");
													temp[0] = 'O'; //VERFLOW!!!!";
													temp[1] = 'V';
													temp[2] = 'E';
													temp[3] = 'R';
													temp[4] = 'F';
													temp[5] = 'L';
													temp[6] = 'O';
													temp[7] = 'W';
													temp[8] = '!';
													temp[9] = '!';
													temp[10] = '!';
													temp[11] = '!';
													temp[12] = '\0';
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	return temp;
}

int CheckMac(char* mac_add){
	int i = 0, sum = 0;
	while (mac_add[i] != '\0'){
		sum++;
		i++;
	}
	//printf("%d\n", sum);
	if (sum != 17){
		return -1;
	}
	else{
	// num of char is right
		for (i = 0; i < 17; i++){
			//printf("%d\t%c\n", i, mac_add[i]);
			if((i + 1) % 3 != 0){
				// not :
				if(!((mac_add[i] >= 'a' && mac_add[i] <= 'f') || (mac_add[i] >= 'A' && mac_add[i] <= 'F') || (mac_add[i] >= '0' && mac_add[i] <= '9'))){
					printf("%c is a BAD char!\n", mac_add[i]);
					return -2;
				}
			}
			else{
				if(mac_add[i] != ':'){
					printf("%c is a BAD delimeter!\n", mac_add[i]);
					return -3;
				}
			}
		}
	}
	return 0;
}


void PrintMac(char* mac_str){
	int i = 0;
	for(i = 0; i < 12; i++){
		printf("%c", mac_str[i]);
		if(((i + 1) % 2 == 0) && (i != 11)){
			printf(":");
		}
	}
	//printf("\n");
}
