from fastapi import FastAPI
from fastapi.responses import FileResponse
from app.core.proceso import run_process


app = FastAPI()

@app.get("/generate")
def generate():
    result = run_process()
    return {"message": result}

@app.get("/download")
def download_csv():
    return FileResponse("resultado/contratistas.csv", media_type="text/csv", filename="contratistas.csv")