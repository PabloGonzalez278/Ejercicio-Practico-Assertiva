from pydantic import BaseModel

class Address(BaseModel):
    city: str

class Company(BaseModel):
    name: str

class User(BaseModel):
    name: str
    email: str
    phone: str
    address: Address
    company: Company

class CSVContratista(BaseModel):
    nombre: str
    telefono: str
    correo: str
    empresa: str
    ciudad: str
    correo_corporativo: str