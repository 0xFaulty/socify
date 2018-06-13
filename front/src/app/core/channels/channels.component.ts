import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-channels',
  templateUrl: './channels.component.html',
  styleUrls: ['./channels.component.scss']
})
export class ChannelsComponent implements OnInit {

  sources: any = [
    {
      name: 'Instagram',
      icon: '../../../assets/images/instagram.svg',
      enabled: true
    },
    {
      name: 'vk',
      icon: '../../../assets/images/vkcom.svg',
      enabled: true
    },
    {
      name: 'Twitter',
      icon: '../../../assets/images/twitter.svg',
      enabled: false
    }
  ];

  channels: any = [
    {
      name: 'news',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/0415af825ce522a95e64c20fa3ca9290/5B8EFEC3/t51.2885-19/s150x150/18723596_313537915736665_1919914805821440000_a.jpg',
      enabled: true
    },
    {
      name: 'mujjostore',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/8174446f3858f47e28c31a8f86c936b0/5B989D70/t51.2885-19/s150x150/12797594_1582277435421114_251708916_a.jpg',
      enabled: true
    },
    {
      name: 'fashionforall',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/a4d5f2965002e1dcf1ac2c9ba3641916/5B93D8CD/t51.2885-19/11259912_984830811537469_2021771870_a.jpg',
      enabled: false
    },
    {
      name: 'realgrumpycat',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/6fc81d63667278d3ceaeac4821d6404d/5B7E3FDC/t51.2885-19/s150x150/17595897_1700002280292981_8013272392845492224_a.jpg',
      enabled: false
    },
    {
      name: 'teddybearabroad',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/66f8f22c45cbf89a7e7c3f1f5642aaf9/5B9DA030/t51.2885-19/s150x150/22801979_190601401509737_5044109884203728896_n.jpg',
      enabled: true
    },
    {
      name: 'akita_sun',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/749b9a6683ab571c8e19d1406e0286bd/5B8D83F5/t51.2885-19/s150x150/22857472_795755550596177_8856233924540497920_n.jpg',
      enabled: true
    },
    {
      name: 'celicas_united',
      imageSource: 'https://scontent-bru2-1.cdninstagram.com/vp/3684ad64dab390c5c0670cf19dd3c9bc/5B78D301/t51.2885-19/11248181_1510222525885058_1502515568_a.jpg',
      enabled: false
    }
  ];

  constructor() {
  }

  ngOnInit() {
  }

}
