import request from '@/utils/request';

export async function selectTruck(params) {
  return request('/api/truck/selectTruck', {
    method: 'POST',
    body: {
      ...params,
      method: 'select',
    },
  });
}

export async function getAdvancedForm(params) {
  return request('/api/truck/getAdvancedForm', {
    method: 'POST',
    body: {
      ...params,
      method: 'getAdvancedForm',
    },
  });
}

export async function deleteTruck(params) {
  return request('/api/truck/deleteTruck', {
    method: 'POST',
    body: {
      ...params,
      method: 'delete',
    },
  });
}

export async function addTruck(params) {
  return request('/api/truck/addTruck', {
    method: 'POST',
    body: {
      ...params,
      method: 'post',
    },
  });
}

export async function updateTruck(params) {
  return request('/api/truck/updateTruck', {
    method: 'POST',
    body: {
      ...params,
      method: 'update',
    },
  });
}