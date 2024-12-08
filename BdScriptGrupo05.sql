create database BDCibertec;
use BDCibertec;

CREATE TABLE Medico
(
 IdMedico 		INT NOT NULL AUTO_INCREMENT,
 NomMedico		VARCHAR(50) NOT NULL,
 ApeMedico 		VARCHAR(50) NOT NULL,
 FechNacMedico	DATE NOT NULL,
 PRIMARY KEY (IdMedico)
);


Insert Into Medico (NomMedico, ApeMedico, FechNacMedico) Values
('Jose', 'Luis', '1990-06-29'),
('Alexandra', 'Villar', '2000-08-15'),
('Alex', 'Diaz', '2003-11-26'),
('Maria', 'Perez', '2011-04-11'),
('Edgar', 'Ramirez', '1999-12-07');


CREATE TABLE Especialidad
(
 IdEspecialidad 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Funcion 			VARCHAR(250) NOT NULL,
 FechGraduacion	DATE NOT NULL,
 IdMedico 			INT NOT NULL,
 PRIMARY KEY (IdEspecialidad),
 FOREIGN KEY (IdMedico) REFERENCES Medico(IdMedico)
 );
 
 
Insert Into Especialidad (Titulo, Funcion, FechGraduacion, IdMedico) Values 
('Cirugía Plástica', 'Corrección y restauración de forma y función en el cuerpo', '2005-06-15', 1),
('Dentista', 'Diagnóstico y tratamiento de problemas dentales', '2002-11-25', 2),
('Pediatría', 'Atención médica de niños y adolescentes', '2012-04-20', 3),
('Otorrinolaringología', 'Tratamiento de trastornos de oído, nariz y garganta', '2008-09-10', 4),
('Cardiología', 'Diagnóstico y tratamiento de enfermedades del corazón', '2010-02-28', 5);

 
 