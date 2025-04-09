import { environment } from 'src/environments/environment';

import * as CryptoJS from "crypto-js";

// Uma chave secreta forte para criptografia AES
const SECRET_KEY = environment.SECRET_KEY; // Use uma chave secreta forte

// Função para hash com SHA-256
function hashSHA256(text: string): string {
  return CryptoJS.SHA256(text).toString(CryptoJS.enc.Hex);
}

// Função para criptografar valores com AES
function encryptAES(value: string): string {
  return CryptoJS.AES.encrypt(value, SECRET_KEY).toString();
}

// Função para descriptografar valores com AES
function decryptAES(cipherText: string): string {
  const bytes = CryptoJS.AES.decrypt(cipherText, SECRET_KEY);
  return bytes.toString(CryptoJS.enc.Utf8);
}

// Função para definir um item no localStorage (criptografando chave e valor)
export function setLocalStorageItem(key: string, value: string): void {
  const hashedKey = hashSHA256(key); // Protege a chave com SHA-256
  const encryptedValue = encryptAES(value); // Criptografa o valor com AES
  localStorage.setItem(hashedKey, encryptedValue);
}

// Função para obter um item do localStorage (descriptografando valor)
export function getLocalStorageItem(key: string): string | null {
  const hashedKey = hashSHA256(key); // Recupera a chave criptografada
  const encryptedValue = localStorage.getItem(hashedKey); // Busca o valor criptografado
  if (encryptedValue) {
    return decryptAES(encryptedValue); // Descriptografa o valor e retorna
  }
  return null;
}

// Função para remover um item do localStorage (usando a chave criptografada)
export function removeLocalStorageItem(key: string): void {
  const hashedKey = hashSHA256(key); // Protege a chave com SHA-256
  localStorage.removeItem(hashedKey);
}

// Função para limpar todos os itens do localStorage
export function clearLocalStorage(): void {
  localStorage.clear();
}

