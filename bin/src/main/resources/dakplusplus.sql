
    
    drop table Adress if exists;

    
    drop table Adress_ContactData if exists;
    drop table Client if exists;
    drop table Company if exists;
	drop table ContactData if exists;
    drop table Employee if exists;
    drop table Employee_IllTime if exists;
    drop table Employee_WorkedHours if exists;
    drop table Equipment if exists;
    drop table IllTime if exists;
    drop table Invoice if exists;
    drop table Invoice_Equipment if exists;
    drop table Invoice_Material if exists;
    drop table Material if exists;
    drop table Planning if exists;
    
    drop table Project if exists;
    drop table Project_Adress if exists;
    drop table Quotation if exists;
    
    drop table Quotation_Material if exists;
    drop table Task if exists;

    drop table WorkedHours if exists;

    drop table Yard_details if exists;

    drop sequence if exists hibernate_sequence			
	
	create sequence hibernate_sequence start with 1 increment by 1;

    
    create table Adress (
       id bigint not null,
        city varchar(255),
        country varchar(255),
        number varchar(255),
        street varchar(255),
        zipCode varchar(255),
        primary key (id)
    );

   create table Adress_ContactData (
       adresses_id bigint not null,
        data_id bigint not null,
        primary key (adresses_id, data_id)
    );
    create table Client (
       id bigint not null,
        name varchar(255),
        company_id bigint,
        contactData_id bigint,
        quotation_id bigint,
        primary key (id)
    );
    
    create table Company (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );
    
    create table ContactData (
       id bigint not null,
        email varchar(255),
        mobile varchar(255),
        company_id bigint,
        employee_id bigint,
        primary key (id)
    );
    
    create table Employee (
       id bigint not null,
        firstName varchar(255),
        lastName varchar(255),
        role varchar(255),
        company_id bigint,
        project_id bigint,
        primary key (id)
    );
 
    
    create table Employee_IllTime (
       Employee_id bigint not null,
        illTimes_id bigint not null,
        primary key (Employee_id, illTimes_id)
    );
 
    
    create table Employee_WorkedHours (
       Employee_id bigint not null,
        hours_id bigint not null,
        primary key (Employee_id, hours_id)
    );
 
    
    create table Equipment (
       id bigint not null,
        cost float not null,
        designation varchar(255),
        quantity integer not null,
        invoice_id bigint,
        task_id bigint,
        primary key (id)
    );
 
    
    create table IllTime (
       id bigint not null,
        begin timestamp,
        end timestamp,
        primary key (id)
    );
 
    
    create table Invoice (
       type varchar(31) not null,
        id bigint not null,
        amount float not null,
        client_id bigint,
        primary key (id)
    );
 
    
    create table Invoice_Equipment (
       Invoice_id bigint not null,
        equipment_id bigint not null
    );
 
    
    create table Invoice_Material (
       Invoice_id bigint not null,
        materials_id bigint not null
    );
 
    
    create table Material (
       id bigint not null,
        cost float not null,
        designation varchar(255),
        quantity float not null,
        invoice_id bigint,
        primary key (id)
    );
 
    
    create table Planning (
       id bigint not null,
        project_id bigint,
        primary key (id)
    );
 
    
    create table Project (
       id bigint not null,
        description varchar(255),
        client_id bigint,
        invoice_id bigint,
        planning_id bigint,
        quotation_id bigint,
        primary key (id)
    );
 
    
    create table Project_Adress (
       projects_id bigint not null,
        adresses_id bigint not null,
        primary key (projects_id, adresses_id)
    );
 
    
    create table Quotation (
       id bigint not null,
        amount float not null,
        client_id bigint,
        project_id bigint,
        primary key (id)
    );
 
    
    create table Quotation_Material (
       Quotation_id bigint not null,
        materials_id bigint not null
    );
 
    
    create table Task (
       id bigint not null,
        begin date,
        designation varchar(255),
        end date,
        planning_id bigint,
        primary key (id)
    );
 
    
    create table WorkedHours (
       id bigint not null,
        begin timestamp,
        end timestamp,
        primary key (id)
    );
 
    
    create table Yard_details (
       Quotation_id bigint not null,
        PARAMETER varchar(255),
        VALUE varchar(255) not null,
        primary key (Quotation_id, VALUE)
    );
 
    
    alter table Employee_IllTime 
       add constraint UK_i2ltx8nmv5slj56xk97uq1wsg unique (illTimes_id);
 
    
    alter table Employee_WorkedHours 
       add constraint UK_6yu18bralmc2tyn5wi5e7apwo unique (hours_id);
 
    
    alter table Invoice_Equipment 
       add constraint UK_ejwolmo47460q6wa44vreotpc unique (equipment_id);
 
    
    alter table Invoice_Material 
       add constraint UK_hm65uukdk624mbpbv4ahrvb1o unique (materials_id);
 
    
    alter table Quotation_Material 
       add constraint UK_iwf4md8bis2b8uhyovu4e4ivb unique (materials_id);
 
    
    alter table Adress_ContactData 
       add constraint FK7hnfwde902x2bpeho73ojvdfv 
       foreign key (data_id) 
       references ContactData;
 
    
    alter table Adress_ContactData 
       add constraint FKq8j7damcdtl4jkgmh2mttlvw0 
       foreign key (adresses_id) 
       references Adress;
 
    
    alter table Client 
       add constraint FK780d0m7y70qbensiitab769n3 
       foreign key (company_id) 
       references Company;
 
    
    alter table Client 
       add constraint FKkaa78dey7gohy9ktev3n5cvjf 
       foreign key (contactData_id) 
       references ContactData;
 
    
    alter table Client 
       add constraint FKbigp981k0tx625f0ipl9cf0r9 
       foreign key (quotation_id) 
       references Quotation;
 
    
    alter table ContactData 
       add constraint FKnhretexuxwcijmh7b00qsp2sh 
       foreign key (company_id) 
       references Company;
 
    
    alter table ContactData 
       add constraint FKhynyc5jw7ivyq48c880qm1xp2 
       foreign key (employee_id) 
       references Employee;
 
    
    alter table Employee 
       add constraint FKogydjhdlcl557ppjr3g8xwmh0 
       foreign key (company_id) 
       references Company;
 
    
    alter table Employee 
       add constraint FK3t65hpb474nlc82c8m8oqpq74 
       foreign key (project_id) 
       references Project;
 
    
    alter table Employee_IllTime 
       add constraint FKph7p5g4do39jv7fo12ocokeom 
       foreign key (illTimes_id) 
       references IllTime;
 
    
    alter table Employee_IllTime 
       add constraint FKp29l1ulaswgkx7osdo9loqoff 
       foreign key (Employee_id) 
       references Employee;
 
    
    alter table Employee_WorkedHours 
       add constraint FKco5ketxohw5hlwyf91qvmtgxx 
       foreign key (hours_id) 
       references WorkedHours;
 
    
    alter table Employee_WorkedHours 
       add constraint FK4xabpf7b3o6p46aalc83rgs7u 
       foreign key (Employee_id) 
       references Employee;
 
    
    alter table Equipment 
       add constraint FKk2oty6mnqx2xeh8ar4nf2wjgk 
       foreign key (invoice_id) 
       references Invoice;
 
    
    alter table Equipment 
       add constraint FKkbhrr0njj5fshdjg09bghf10m 
       foreign key (task_id) 
       references Task;
 
    
    alter table Invoice 
       add constraint FKkv1b8wqr62mkjb7g52bosrk3x 
       foreign key (client_id) 
       references Client;
 
    
    alter table Invoice_Equipment 
       add constraint FKdbb4t333og2w21514a4v1r5h5 
       foreign key (equipment_id) 
       references Equipment;
 
    
    alter table Invoice_Equipment 
       add constraint FKlpwk9wlwqo90tunpd9r4jylao 
       foreign key (Invoice_id) 
       references Invoice;
 
    
    alter table Invoice_Material 
       add constraint FKogi0u9hyf2y5sausxwn59woq2 
       foreign key (materials_id) 
       references Material;
 
    
    alter table Invoice_Material 
       add constraint FKt2cmfcx5o2vhd65wpxmv110nb 
       foreign key (Invoice_id) 
       references Invoice;
 
    
    alter table Material 
       add constraint FK9xvttx99sgl35jae8on9htmkc 
       foreign key (invoice_id) 
       references Invoice;
 
    
    alter table Planning 
       add constraint FKpbxd0yslfdrjka7xv8yar731x 
       foreign key (project_id) 
       references Project;
 
    
    alter table Project 
       add constraint FKfx7y3n5xaohuopukj6rw1tl9p 
       foreign key (client_id) 
       references Client;
 
    
    alter table Project 
       add constraint FK4fn029tgubq2ctk8euqhsyppg 
       foreign key (invoice_id) 
       references Invoice;
 
    
    alter table Project 
       add constraint FK78cqr018swx6cmrpcae0vmmg0 
       foreign key (planning_id) 
       references Planning;
 
    
    alter table Project 
       add constraint FK8btfbfy6k2droylqb80edr4c7 
       foreign key (quotation_id) 
       references Quotation;
 
    
    alter table Project_Adress 
       add constraint FKf6594xlj3us6swd0xuyuilfgl 
       foreign key (adresses_id) 
       references Adress;
 
    
    alter table Project_Adress 
       add constraint FKf8kjwyqy7noqjattdd81rpb1j 
       foreign key (projects_id) 
       references Project;
 
    
    alter table Quotation 
       add constraint FKdirxoacd9nwtfrgarmvp99m9o 
       foreign key (client_id) 
       references Client;
 
    
    alter table Quotation 
       add constraint FKdd82i5q2rxa0cdj3x5ermq0jn 
       foreign key (project_id) 
       references Project;
 
    
    alter table Quotation_Material 
       add constraint FKcelv3km4mjxhpo79rwxb46ed3 
       foreign key (materials_id) 
       references Material;
 
    
    alter table Quotation_Material 
       add constraint FKhjy9rgd1o5ueqam3vyyvc79x7 
       foreign key (Quotation_id) 
       references Quotation;
 
    
    alter table Task 
       add constraint FKs64s1qkodjvy6etn0ier9cm6e 
       foreign key (planning_id) 
       references Planning;
 
    
    alter table Yard_details 
       add constraint FK7qi14aj7qayhrdc87pl37m6le 
       foreign key (Quotation_id) 
       references Quotation;

    insert 
    into
        Company
        (name, id) 
    values
        ("Dakplusplus", 1);
 
    insert 
    into
        ContactData
        (company_id, email, employee_id, mobile, id) 
    values
        (1, "john@smith.com", 1, "0477727847", 1);
 
    insert 
    into
        Adress
        (city, country, number, street, zipCode, id) 
    values
        ("Brussels", "Belgium", "16", "Roupeplein", "1000", 1);
 
    insert 
    into
        Client
        (company_id, contactData_id, name, quotation_id, id) 
    values
        (1, 1, "John", 1, 1);
 
    
    
