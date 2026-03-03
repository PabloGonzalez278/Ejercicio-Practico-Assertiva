from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    endpoint: str = "https://jsonplaceholder.typicode.com/users"
    output_csv: str = "resultado/Contratistas.csv"
    domain: str = "democompany.com"

    class Config:
        env_file = ".env"

settings = Settings()