from fastapi import FastAPI
from app.core.proceso import run_process

app = FastAPI()

@app.get("/generate")
def generate():
    result = run_process()
    return {"message": result}