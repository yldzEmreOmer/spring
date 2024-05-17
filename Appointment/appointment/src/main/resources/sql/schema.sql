CREATE TABLE Appointment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_Name VARCHAR(255) NOT NULL,
    last_Name VARCHAR(255) NOT NULL,
    date_Of_Appointment DATE NOT NULL,
    contact_Number CHAR(10) NOT NULL,
    department VARCHAR(255) NOT NULL,
    national_Id CHAR(11) NOT NULL,
    reason TEXT NOT NULL
);
