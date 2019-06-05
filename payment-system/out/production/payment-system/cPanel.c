#include <stdio.h>
#include <string.h>
#include <stdlib.h> 
#include <time.h>

int verifyId(int idsEmployee[], int maxPeople, int idEmployee) {
	if(idEmployee >= maxPeople) return 0;
	else if(idsEmployee[idEmployee] == 0) return 0;
	else return 1;
}

int getNewId(int idsEmployee[], int maxPeople) {
	for(int i = 0; i < maxPeople; i++) {
		if(idsEmployee[i] == 0) {
			idsEmployee[i] = 1;
			return i;
		}
	}
	return -1;
}

int getNewidsEmployeeyndicate(int idsSyndicate[], int maxPeople) {
	for(int i = maxPeople - 1; i >= 0; i--) {
		if(idsSyndicate[i] == 0) {
			idsSyndicate[i] = 1;
			return i;
		}
	}
	return -1;
}

void copyMatriz(int maxPeople, char mUnRedo[][maxPeople][256], char mPeople[][256], int i) {

}

void newUndo(int maxPeople, char mPeople[][256], int idsEmployee[], int idsSyndicate[], char undo[][maxPeople][256], int undoIdsEmployee[][maxPeople], int undoIdsSyndicate[][maxPeople], int undoVerify[]) {
	for(int i = 0; i < maxPeople; i++) {
		if(undoVerify[i] == 0) {
			for(int j = 0; j < maxPeople; j++) {
				strcpy(undo[i][j], mPeople[j]);
			}
			//strcpy(undoIdsEmployee[i], idsEmployee);
			//strcpy(undoIdsSyndicate[i], idsSyndicate);
		}
		break;
	}
}


void newPeople(int maxPeople, char mPeople[][256], int idsEmployee[], int idsSyndicate[], char undoPeople[][maxPeople][256], int undoIdsEmployee[][maxPeople], int undoIdsSyndicate[][maxPeople], int undoVerify[], int *tPeople) {
	system("clear");
	char people[256] = "";
	int idEmployee;
	char name[256];
	char address[256];
	char typeEmployee[256];
	char paymentMethod[256];
	int syndicate = 0;
	int idsEmployeeyndicate = -1;
	int syndicateRate = 0;
	int optionType = 0;
	char optionOk;

	idEmployee = getNewId(idsEmployee, maxPeople);
	printf("Name: ");
	scanf("%s", name);
	printf("Address: ");
	scanf("%s", address);
	
	do {
		printf("[1] - Commissioned\n");
		printf("[2] - Salaried\n");
		printf("[3] - Hourly\n");
		printf("T. Employee: ");
		scanf(" %d", &optionType);

		if(optionType == 1) {
		       	strcpy(typeEmployee, "Commissioned");
			strcpy(paymentMethod, "bi-semanalmente");
		}
		else if(optionType == 2) {
			strcpy(typeEmployee, "Salaried");
			strcpy(paymentMethod, "mensalmente");
		}
		else if(optionType == 3) {
			strcpy(typeEmployee, "Hourly");
			strcpy(paymentMethod, "semanalmente");
		}
		else optionType = 0;
	} while(optionType == 0);

	printf("\nID: %d\n", idEmployee);
	printf("Name: %s\n", name);
	printf("Address: %s\n", address);
	printf("T. Employee: %s\n", typeEmployee);
	printf("P. Method: %s\n", paymentMethod);
	printf("Syndicate: %d\n", syndicate);
	//printf("Id Syndicate: %d\n", idsEmployeeyndicate);
	//printf("Syndicate Rate: %d\n", syndicateRate);
	
	printf("\nConfirm[Y/n]: ");
	scanf(" %c", &optionOk);

	if(optionOk == 'y' || optionOk == 'Y' || optionOk == 10) {
		char idEmployeeAux[10];
		sprintf(idEmployeeAux, "%i", idEmployee);
		char TEMP1[128] = "[idEmployee]=";
		strcat(TEMP1, idEmployeeAux);
		strcat(people, TEMP1);

		char TEMP2[128] = "[name]=";
		strcat(TEMP2, name);
		strcat(people, TEMP2);
		
		char TEMP3[128] = "[address]=";
		strcat(TEMP3, address);
		strcat(people, TEMP3);
		
		char TEMP4[128] = "[typeEmployee]=";
		strcat(TEMP4, typeEmployee);
		strcat(people, TEMP4);
		
		char TEMP5[128] = "[paymentMethod]=";
		strcat(TEMP5, paymentMethod);
		strcat(people, TEMP5);
		
		char syndicateAux[10];
		sprintf(syndicateAux, "%i", syndicate);
		char TEMP6[128] = "[syndicate]=";
		strcat(TEMP6, syndicateAux);
		strcat(people, TEMP6);
		
		char idsEmployeeyndicateAux[10];
		sprintf(idsEmployeeyndicateAux, "%i", idsEmployeeyndicate);
		char TEMP7[128] = "[idsEmployeeyndicate]=";
		strcat(TEMP7, idsEmployeeyndicateAux);
		strcat(people, TEMP7);
		
		char syndicateRateAux[10];
		sprintf(syndicateRateAux, "%i", syndicateRate);
		char TEMP8[128] = "[syndicateRate]=";
		strcat(TEMP8, syndicateRateAux);
		strcat(people, TEMP8);

		strcat(people, "[]");
		newUndo(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify);
		strcpy(mPeople[idEmployee], people);

		*tPeople += 1;
		printf("Registered employee\n");
	}
	else { 
		printf("Unregistered employee\n");
	}
}

void editPeople(int maxPeople, char mPeople[][256], int idsEmployee[], int idsSyndicate[], char undoPeople[][maxPeople][256], int undoIdsEmployee[][maxPeople], int undoIdsSyndicate[][maxPeople], int undoVerify[]) {
	system("clear");
	int idEmployee;
	printf("Employee ID: ");
	scanf("%d", &idEmployee);
	
	char TEMP[256];
	char people[256];
	char name[256];
	char address[256];
	char typeEmployee[256];
	char paymentMethod[256];
	char syndicate[256];
	char idsEmployeeyndicate[256];
	char syndicateRate[256];
	char tEquality = 0;
	int i = 0, j = 0;
	int menu;

	if(!verifyId(idsEmployee, maxPeople, idEmployee)) {
		printf("Employee not found\n");
		return;
	}

	while(mPeople[idEmployee][i] != '\0') {
		if(mPeople[idEmployee][i] == '=') {
			i += 1;
			while(mPeople[idEmployee][i] != '[') {
				TEMP[j++] = mPeople[idEmployee][i++];
			}
			TEMP[j] = '\0';
			//if(tEquality == 0) strcpy(idEmployee, TEMP);
			if(tEquality == 1) strcpy(name, TEMP);
			if(tEquality == 2) strcpy(address, TEMP);
			if(tEquality == 3) strcpy(typeEmployee, TEMP);
			if(tEquality == 4) strcpy(paymentMethod, TEMP);
			if(tEquality == 5) strcpy(syndicate, TEMP);
			if(tEquality == 6) strcpy(idsEmployeeyndicate, TEMP);
			if(tEquality == 7) strcpy(syndicateRate, TEMP);
			strcpy(TEMP, "");
			tEquality += 1; j = 0;
		}
		i += 1;
	}

	do {
		system("clear");
		printf("ID: %d\n", idEmployee);
		if(atoi(syndicate)) {
			printf("ID Syndicate: %s\n", idsEmployeeyndicate);
		}
		printf("[1] - Name: %s\n", name);
		printf("[2] - Address: %s\n", address);
		printf("[3] - T. Employee: %s\n", typeEmployee);
		printf("[4] - P. Method: %s\n", paymentMethod);
		printf("[5] - Syndicate: %s\n", syndicate);
		if(atoi(syndicate)) {
			printf("[6] - Syndicate Rate: %s\n", syndicateRate);
		}

		printf("\n[0] - Finish Editing\n\n");
		printf("Select option: ");
		scanf("%d", &menu);

		if(menu == 1) {
			printf("\nName: ");
			scanf("%s", name);
		}
		if(menu == 2) {
			printf("\nAddress: ");
			scanf("%s", address);
		}
		if(menu == 3) {
			printf("\nT. Employee: ");
			scanf("%s", typeEmployee);
		}
		if(menu == 4) {
			printf("\nP. Method: ");
			scanf("%s", paymentMethod);
		}
		if(menu == 5) {
			printf("\nSyndicate: ");
			scanf("%s", syndicate);

			if(atoi(syndicate)) {
				sprintf(idsEmployeeyndicate, "%i", getNewidsEmployeeyndicate(idsSyndicate, maxPeople));
				sprintf(syndicateRate, "%i", 25);
			}
		}
		if(menu == 6 && atoi(syndicate)) {
			printf("\nSyndicate Rate: ");
			scanf("%s", syndicateRate);
		}
		if(menu == 0) {
			char idEmployeeAux[10];
			sprintf(idEmployeeAux, "%i", idEmployee);
			char TEMP1[128] = "[idEmployee]=";
			strcat(TEMP1, idEmployeeAux);
			strcat(people, TEMP1);

			char TEMP2[128] = "[name]=";
			strcat(TEMP2, name);
			strcat(people, TEMP2);
			
			char TEMP3[128] = "[address]=";
			strcat(TEMP3, address);
			strcat(people, TEMP3);
			
			char TEMP4[128] = "[typeEmployee]=";
			strcat(TEMP4, typeEmployee);
			strcat(people, TEMP4);
			
			char TEMP5[128] = "[paymentMethod]=";
			strcat(TEMP5, paymentMethod);
			strcat(people, TEMP5);
			
			char TEMP6[128] = "[syndicate]=";
			strcat(TEMP6, syndicate);
			strcat(people, TEMP6);
			
			char TEMP7[128] = "[idsEmployeeyndicate]=";
			strcat(TEMP7, idsEmployeeyndicate);
			strcat(people, TEMP7);
			
			char TEMP8[128] = "[syndicateRate]=";
			strcat(TEMP8, syndicateRate);
			strcat(people, TEMP8);

			strcat(people, "[]");
			newUndo(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify);
			strcpy(mPeople[idEmployee], people);
				
			printf("Sucess\n");
		}
	} while(menu);
}

void removePeople(int maxPeople, char mPeople[][256], int idsEmployee[], int idsSyndicate[], char undoPeople[][maxPeople][256], int undoIdsEmployee[][maxPeople], int undoIdsSyndicate[][maxPeople], int undoVerify[], int *tPeople) {
	system("clear");
	int idEmployee;
	printf("Employee ID: ");
	scanf("%d", &idEmployee);
	
	char TEMP[256];
	char name[256];
	char address[256];
	char typeEmployee[256];
	char paymentMethod[256];
	char syndicate[256];
	char idsEmployeeyndicate[256];
	char syndicateRate[256];
	char tEquality = 0;
	int i = 0, j = 0;
	int menu;
	char optionOk;

	if(!verifyId(idsEmployee, maxPeople, idEmployee)) {
		printf("Employee not found\n");
		return;
	}

	while(mPeople[idEmployee][i] != '\0') {
		if(mPeople[idEmployee][i] == '=') {
			i += 1;
			while(mPeople[idEmployee][i] != '[') {
				TEMP[j++] = mPeople[idEmployee][i++];
			}
			TEMP[j] = '\0';
			//if(tEquality == 0) strcpy(idEmployee, TEMP);
			if(tEquality == 1) strcpy(name, TEMP);
			if(tEquality == 2) strcpy(address, TEMP);
			if(tEquality == 3) strcpy(typeEmployee, TEMP);
			if(tEquality == 4) strcpy(paymentMethod, TEMP);
			if(tEquality == 5) strcpy(syndicate, TEMP);
			if(tEquality == 6) strcpy(idsEmployeeyndicate, TEMP);
			if(tEquality == 7) strcpy(syndicateRate, TEMP);
			strcpy(TEMP, "");
			tEquality += 1; j = 0;
		}
		i += 1;
	}

	system("clear");
	printf("ID: %d\n", idEmployee);
	if(atoi(syndicate)) {
		printf("ID Syndicate: %s\n", idsEmployeeyndicate);
	}
	printf("Name: %s\n", name);
	printf("Address: %s\n", address);
	printf("T. Employee: %s\n", typeEmployee);
	printf("P. Method: %s\n", paymentMethod);
	printf("Syndicate: %s\n", syndicate);
	if(atoi(syndicate)) {
		printf("Syndicate Rate: %s\n", syndicateRate);
	}

	printf("\nConfirm[Y/n]: ");
	scanf(" %c", &optionOk);

	if(optionOk == 'y' || optionOk == 'Y' || optionOk == 10) {
		newUndo(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify);
		strcpy(mPeople[idEmployee], "");
		idsEmployee[idEmployee] = 0;
		if(atoi(syndicate)) idsSyndicate[atoi(idsEmployeeyndicate)] = 0;
		printf("Removal completed\n");
	}
	else printf("Removal canceled\n");
}

void viewAllPeople(char mPeople[][256], int maxPeople) {
	for(int i = 0; i < maxPeople; i++) {
		printf("%s\n", mPeople[i]);
	}
}

void admPanel(int maxPeople) {
	int tPeople = 0;
	int menu;

	char mPeople[maxPeople][256];
	int idsEmployee[maxPeople];
	int idsSyndicate[maxPeople];
	
	char undoPeople[maxPeople][maxPeople][256];
	char redoPeople[maxPeople][maxPeople][256];
	int undoIdsEmployee[maxPeople][maxPeople];
	int undoIdsSyndicate[maxPeople][maxPeople];
	int redoIdsEmployee[maxPeople][maxPeople];
	int redoIdsSyndicate[maxPeople][maxPeople];
	int undoVerify[maxPeople];
	int redoVerify[maxPeople];
	
	memset(idsEmployee, 0, sizeof(int));
	memset(idsSyndicate, 0, sizeof(int));
	memset(undoVerify, 0, sizeof(int));
	memset(redoVerify, 0, sizeof(int));

	do {
		system("clear");
		if(tPeople < maxPeople) {
			printf("[1] - New People\n");
		}
		printf("[2] - Edit People\n");
		printf("[3] - Remove  People\n");
		printf("[4] - View All People\n");
		printf("[0]- Quit\n");

		printf("Select option: ");
		scanf("%d", &menu);

		if(menu == 1) newPeople(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify, &tPeople);
		if(menu == 2) editPeople(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify);
		if(menu == 3) removePeople(maxPeople, mPeople, idsEmployee, idsSyndicate, undoPeople, undoIdsEmployee, undoIdsSyndicate, undoVerify, &tPeople);
		
		if(menu == 4) viewAllPeople(mPeople, maxPeople);
		if(menu == 0) printf("Thanks\n");
		
		clock_t start, end;
    	int time = 2000;
		end = (time/1000) * CLOCKS_PER_SEC;
    	start = clock();
    	while((clock() - start) < end){}; 

	} while(menu);
}

int main() {
	system("clear");
	int maxPeople;
	printf("Enter the number of employees: ");
	scanf("%d", &maxPeople);
	admPanel(maxPeople);
	return 0;
}
