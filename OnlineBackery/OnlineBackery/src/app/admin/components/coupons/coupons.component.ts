import { Component } from '@angular/core';
import { AdminService } from '../../service/admin.service';

@Component({
  selector: 'app-coupns',
  templateUrl: './coupons.component.html',
  styleUrls: ['./coupons.component.scss']
})
export class CouponsComponent {

  coupons: any;
  constructor(private adminService: AdminService) { }

ngonInit (){
this.getCoupons();
}

getCoupons () {
this.adminService.getCoupons().subscribe(res =>{
this.coupons = res;
})
}
}
