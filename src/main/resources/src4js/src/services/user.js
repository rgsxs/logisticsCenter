import request from '@/utils/request';

export async function query() {
  return request('/api/users/query');
}

export async function queryCurrent() {
  return request('/api/users/currentUser');
}
